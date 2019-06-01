/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Date;

/**
 *
 * @author cristianalarizza
 */
public class DateManager {

   public static Date truncate(long time, int min) {
      return new Date(time - time % (60000 * min));
   }
}
