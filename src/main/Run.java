/*
 * TERALABOT
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import constant.Constants;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author LuigiZ
 */
public class Run {

   /**
    * @param args the command line arguments
    */
   public static void main(String[] args) throws IOException {
      // TODO code application logic here
      Task t = new Task();
      Date now = new Date();
      System.out.print("Start " + Constants.getTimeFormat().format(now));
      switch (args[0]) {
         case "sl": // upload locations e sensori
            t.createJsonSensor();
            break;
         case "past":
            System.out.println(" - upload past data");
            t.runPast();
            break;
         case "default":
            System.out.println(" - upload last data");
            t.runDefault();
            break;
         default:
            break;
      }
      Date end = new Date();
      System.out.println("End " + Constants.getTimeFormat().format(end) + " ("+(end.getTime()-now.getTime())/1000+ " sec)");

   }

}
