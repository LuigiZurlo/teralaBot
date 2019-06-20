/*
 * TERALABOT
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import constant.Constants;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

/**
 *
 * @author LuigiZ
 */
public class Run {

   /**
    * @param args the command line arguments
    */
   public static void main(String[] args) throws IOException, ParseException {
      // TODO code application logic here
      String mode = "json";
      System.out.println("mode " + mode);
      Task t = new Task(mode);
      Date now = new Date();
      System.out.println("Start " + Constants.getTimeFormat().format(now));
      if (args.length > 0) {
         switch (args[0]) {
            case "sl": // upload locations e sensori
               t.createJsonSensor();
               break;
            case "single_sl": // upload location e dati di un solo sensore
               t.createJsonSensor(args[1]);
               break;
            case "past": // uploads all past sensors measurements from now
               System.out.println(" - uploading past data");
               t.runPast();
               break;
            case "past_period": // uploads all  sensors measurements within a given period 
               System.out.println(" - uploading all past data ["+args[1]+"-"+args[2]+"]");
               t.runPast(args[1], args[2]);
//            t.runPast();
               break;
            case "past_single": // uploads a sensor's measurements within a given period 
               System.out.println(" - uploading past data of sensor "+args[1]+ " ["+args[2]+"-"+args[3]+"]");
               t.runPast(args[1], args[2], args[3]);
               break;
            case "default":
               System.out.println(" - uploading last data");
               t.runDefault();
               break;
            default:
               System.out.print(help());
               break;
         }
      } else {
          System.out.print(help());
      }
      Date end = new Date();
      System.out.println("End " + Constants.getTimeFormat().format(end) + " (" + (end.getTime() - now.getTime()) / 1000 + " sec)");

   }

   static String help() {
      StringBuilder sb = new StringBuilder();
      sb.append("usages").append("\n");
      sb.append("sl\n\tuploads all locations and sensors informations").append("\n");
      sb.append("single_sl <id>\n\tuploads location and information of a single sensor (by location_id)").append("\n");
      sb.append("past\n\tuploads past measurements of all active sensors from now").append("\n");
      sb.append("past_period <start> <end>\n\tuploads all past sensors measurements within the given period").append("\n");
      sb.append("past_single <id> <start> <end>\n\tuploads past measurements of a sigle sensor (by location_id), within the given period").append("\n");
      sb.append("default\n\tuploads last measurements of all active sensors").append("\n");
      return sb.toString();
   }

}
