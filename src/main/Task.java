/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import constant.Query;
import domain.Location;
import domain.Measurementavg;
import domain.Parameter2;
import domain.Sensor;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import json.*;
import util.ManagerDB;
import util.QueryParameter;

/**
 *
 * @author LuigiZ
 */
public class Task {

    private static final String temperature = "air_temperature";
    private static final String pressure = "atmospheric_pressure";

    public void runPast() throws IOException {
        ArrayList<QueryParameter> queryParameters = new ArrayList<>();
        List<Object> locations = ManagerDB.getObjectList(Query.GET_LOCATION_TEST, queryParameters);
//        for (Location location : ((List<Location>) (List<?>) (locations))) {
        Location l = (Location) locations.get(0);

        Datum ric = new Datum("PA-" + l.getSensor().getPrimaryPurpleairId());
        List<Data> parametri = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            queryParameters.add(new QueryParameter("location_id", l.getId()));
            queryParameters.add(new QueryParameter("param_id", i));

            List<Measurementavg> mis = (List<Measurementavg>) (List<?>) ManagerDB.getObjectList(Query.GET_SENSOR_MEASURES, queryParameters);
            if (!mis.isEmpty()) {
                Data variabile = null;
                if (mis.get(0).getParameter().getId() == 4) {
                    variabile = new Data(temperature, mis.get(0).getParameter().getUnit());
//                    System.out.println("temperature");
                } else if (mis.get(0).getParameter().getId() == 6) {
                    variabile = new Data(pressure, mis.get(0).getParameter().getUnit());
                } else {
                    variabile = new Data(mis.get(0).getParameter().getCode(), mis.get(0).getParameter().getUnit());
                }
                List<Value> valori = new ArrayList<>();
                for (Measurementavg mi : mis) {
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    valori.add(new Value(mi.getValore(), dateFormat.format(mi.getTimestamp())));
                }
                variabile.setValues(valori);
                parametri.add(variabile);
            }
        }

        ric.setData(parametri);
        Request r = new Request();
        List<Datum> d = new ArrayList<>();
        d.add(ric);
        r.setData(d);
        toJson(r, "C:\\Users\\LuigiZ\\Desktop\\prova.json");

//        }
    }

    public void runDefault() {
        ArrayList<QueryParameter> queryParameters = new ArrayList<>();
        List<Object> locations = ManagerDB.getObjectList(Query.GET_LOCATION_TO_UPDATE, queryParameters);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Request r = new Request();
        List<Datum> data = new ArrayList<>();
        for (Location l : ((List<Location>) (List<?>) (locations))) {
            Datum ric = new Datum("PA-" + l.getSensor().getPrimaryPurpleairId());
            System.out.println("Scarico misure sensore " + l.getSensor().getDisplayName() );
            queryParameters.add(new QueryParameter("location_id", l.getId()));
            List<Measurementavg> mis = (List<Measurementavg>) (List<?>) ManagerDB.getObjectList(Query.GET_LAST_SENSOR_MEASURE, queryParameters);

            for (Measurementavg mi : mis) {

                List<Value> valori = new ArrayList<>();

                valori.add(new Value(mi.getValore(), dateFormat.format(mi.getTimestamp())));
                Data dato = new Data(getParameterName(mi.getParameter()), mi.getParameter().getUnit());
                dato.setValues(valori);

                ric.addData(dato);
            }
            
            data.add(ric);
            queryParameters.clear();
        }
        
        r.setData(data);
        
        toJson(r,"C:\\Users\\LuigiZ\\Desktop\\provaDefault.json");

    }

    public void createJsonSensor() {
        String root = "C:\\Users\\LuigiZ\\Desktop\\jsons\\";

        ArrayList<QueryParameter> queryParameters = new ArrayList<>();
        List<Location> locations = (List<Location>) (List<?>) ManagerDB.getObjectList(Query.GET_LOCATION_TO_UPDATE, queryParameters);
        for (Location location : locations) {
            String code = "PA-" + location.getSensor().getPrimaryPurpleairId();
            RegisterEnvironmentDevice dev = new RegisterEnvironmentDevice(code);
            RegisterEnvironmentDeviceLocation loc = new RegisterEnvironmentDeviceLocation(code, location.getGeolocation().getY(), location.getGeolocation().getX(), location.getElevation(), location.getSensor().getDisplayName());
            toJson(dev, root + RegisterEnvironmentDevice.class.getSimpleName() + code + ".json");
            toJson(loc, root + RegisterEnvironmentDeviceLocation.class.getSimpleName() + code + ".json");
        }

    }

    private String getParameterName(Parameter2 p) {

        if (p.getId() == 4) {
            return temperature;
        } else if (p.getId() == 6) {
            return pressure;
        } else {
            return p.getCode();
        }

    }

    private void toJson(Object o, String f) {
        ObjectMapper m = new ObjectMapper();
        try {
            m.writeValue(new File(f), o);
        } catch (IOException ex) {
            Logger.getLogger(Task.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
