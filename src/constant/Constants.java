/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constant;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 *
 * @author cristianalarizza
 */
public class Constants {

   public static final int SLICE_TIME = 10;
   public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

   public static SimpleDateFormat getTimeFormat() {
      sdf.setTimeZone(TimeZone.getTimeZone( "UTC" ) );
      return sdf;
   }

}
