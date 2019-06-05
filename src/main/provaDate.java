/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import static main.provaDate.sdf;

/**
 *
 * @author cristianalarizza
 */
public class provaDate {

   public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

   public static void main(String[] args) {
      Date now = new Date();
      System.out.println("tz " + getTimeFormat().format(now) + "  no Format " + now);

   }

   private static SimpleDateFormat getTimeFormat() {
      sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
      return sdf;
   }
}
