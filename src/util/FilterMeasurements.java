/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import constant.Constants;
import domain.Measurementavg;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cristianalarizza
 */
public class FilterMeasurements {
   
   
   public static List<Measurementavg> filterOut(List<Measurementavg> list, Thresholds th){
      List<Measurementavg> toRemove= new ArrayList<>();
      System.out.println("parametro = " + list.get(0).getParameter().getCode());
      for(Measurementavg m:list){
         th.setMonth(m.getTimestamp().getMonth());
          // controllo sui valori fuori range
           if(!(m.getValore().compareTo(th.getMin(m.getParameter().getCode()))>=0 
                 && m.getValore().compareTo(th.getMax(m.getParameter().getCode()))<=0)){
            System.out.println( m.getValore()+ " "+ Constants.getTimeFormat().format(m.getTimestamp()));
            toRemove.add(m);
         }
      }
      list.removeAll(toRemove);
      return list;
   }

}
