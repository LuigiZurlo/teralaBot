/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import com.vividsolutions.jts.geom.Point;
//import com.vividsolutions.jts.geom.Geometry;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.annotations.Type;

/**
 *
 * @author luigizurlo
 */
@Entity
//@Audited
@Table(name = "location", schema = "raw_data_test")
@SequenceGenerator(name = "location_gen", sequenceName = "location_id_seq", allocationSize = 1)
public class Location implements Serializable {
//    private static final long serialVersionUID = ObjectStreamClass.lookup(Location.class).getSerialVersionUID();

    private static final long serialVersionUID = -8211695100936100048L;

//       @Column(columnDefinition="geometry(Point,4326)", name = "geolocation")
//        //@Column (name = "geolocation")
//        private Point geolocation;
    // @Column(columnDefinition="geometry(Point,4326)", name = "geolocation")
    @Column(columnDefinition = "Geometry")
    @Type(type = "org.hibernate.spatial.GeometryType")
    private Point geolocation;

    @Column(name = "elevation")
    private BigDecimal elevation;

    @Column(name = "valid_from")
    private Date validFrom;

    @Column(name = "valid_to")
    private Date validTo;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sensor_id", referencedColumnName = "id")
    private Sensor sensor;

    public Location() {
    }

    public Location(Point geolocation, BigDecimal elevation, Date validFrom, Date validTo, Sensor sensor) {

        this.geolocation = geolocation;
        this.elevation = elevation;
        this.validFrom = validFrom;
        this.validTo = validTo;
        this.sensor = sensor;
    }

    public Point getGeolocation() {
        return geolocation;
    }

    public void setGeolocation(Point geolocation) {
        this.geolocation = geolocation;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTo() {
        return validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor_id) {
        this.sensor = sensor_id;
    }

    public BigDecimal getElevation() {
        return elevation;
    }

    public void setElevation(BigDecimal elevation) {
        this.elevation = elevation;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "location_gen")
    @Column(name = "id", columnDefinition = "bigserial", insertable = true, updatable = true, unique = true)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
