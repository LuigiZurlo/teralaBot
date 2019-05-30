/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import com.sun.scenario.effect.Offset;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.util.Date;

/**
 *
 * @author luigizurlo
 */
@Entity
@Table(name = "measurementavg", schema = "raw_data_test")
@SequenceGenerator(name = "measurementavg_gen", sequenceName = "raw_data_test.measurementavg_seq_id", allocationSize = 1)

public class Measurementavg implements Serializable {

   private static final long serialVersionUID = -8211695100936100048L;

//        //@ManyToOne (fetch = FetchType.LAZY)
//	@JoinColumn (name = "location_id", referencedColumnName = "id")
//	private Long location_id;
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "location_id", referencedColumnName = "id")
   private Location location;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "parameter2_id", referencedColumnName = "id")
   private Parameter2 parameter;

   @Column(name = "timestamp")
   private Date timestamp;

   @Column(name = "value")
   private BigDecimal valore;

   public Measurementavg() {
   }

   public Measurementavg(Location location, Parameter2 parameter, Date timestamp, BigDecimal valore) {
      this.location = location;
      this.parameter = parameter;
      this.timestamp = timestamp;
      this.valore = valore;
   }

   public BigDecimal getValore() {
      return valore;
   }

   public void setValore(BigDecimal valore) {
      this.valore = valore;
   }

   

   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "measurementavg_gen")   
   @Column(name = "id", columnDefinition = "bigserial", insertable = true, updatable = true, unique = true)
   private Long id;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }



   public Parameter2 getParameter() {
      return parameter;
   }

   public void setParameter(Parameter2 parameter) {
      this.parameter = parameter;
   }

   public Date getTimestamp() {
      return timestamp;
   }

   public void setTimestamp(Date timestamp) {
      this.timestamp = timestamp;
   }

   public Location getLocation() {
      return location;
   }

   public void setLocation(Location location) {
      this.location = location;
   }

}
