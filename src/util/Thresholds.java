/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author cristianalarizza
 */
public class Thresholds {

   private Map<String, Ths> t;
   private int thTemp[] = {-13, -13, -4, 0, 0, 8, 10, 10, 8, 5, -2, -8};

   public Thresholds() {
      t = new HashMap<>();
      t.put("temperature", new Ths(new BigDecimal(-10), new BigDecimal(40)));
      t.put("pressure", new Ths(new BigDecimal(90000), new BigDecimal(104000)));
      t.put("humidity", new Ths(new BigDecimal(0), new BigDecimal(100)));
      t.put("pm1", new Ths(new BigDecimal(0), new BigDecimal(1000)));
      t.put("pm25", new Ths(new BigDecimal(0), new BigDecimal(1000)));
      t.put("pm10", new Ths(new BigDecimal(0), new BigDecimal(1000)));
   }

   public void setMonth(int m) {
      t.put("temperature", new Ths(new BigDecimal(thTemp[m]), new BigDecimal(40)));
   }

   public BigDecimal getMin(String code) {
      return t.get(code).getMin();
   }

   public BigDecimal getMax(String code) {
      return t.get(code).getMax();
   }

   private class Ths {

      private BigDecimal min, max;

      public Ths(BigDecimal min, BigDecimal max) {
         this.min = min;
         this.max = max;
      }

      public BigDecimal getMin() {
         return min;
      }

      public BigDecimal getMax() {
         return max;
      }
   }
}
