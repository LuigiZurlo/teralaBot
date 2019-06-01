/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author cristianalarizza
 */
public class TestDate {

   public static void main(String[] args) throws ParseException {
      SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
      Date now = new Date();
      now = df.parse("2019-05-31 17:22:38");
      System.out.println("df = " + df.format(now));
      long milli = now.getTime();
    
      Date data = new Date(tronca(milli, 10));
      System.out.println("df = " + df.format(data));
   }
   
   private static long tronca(long time, int min){
      return time-time%(60000*min);
   }
}
