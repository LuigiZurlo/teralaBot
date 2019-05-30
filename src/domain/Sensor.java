/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author luigizurlo
 */
@Entity
//@Audited
@Table(name = "sensor", schema = "raw_data_test")
@SequenceGenerator(name = "sensor_gen", sequenceName = "sensor_id_seq", allocationSize = 1)

public class Sensor implements Serializable{
    
   private static final long serialVersionUID = -8211695100936100048L;
    
    
                
        @Column(name = "primary_purpleair_id", length = 20)
	private String primaryPurpleairId; 
        
        @Column(name = "secondary_purpleair_id", length = 20)
	private String secondaryPurpleairId;    
        
        @Column(name = "display_name", length = 100)
	private String displayName; 
        
        @Column(name = "primary_channel_a", length = 20)
	private String primaryChannelA; 
        
        @Column(name = "primary_channel_b", length = 20)
	private String primaryChannelB; 
        
        @Column(name = "secondary_channel_a", length = 20)
	private String secondaryChannelA; 
        
        @Column(name = "secondary_channel_b", length = 20)
	private String secondaryChannelB;
        
        @Column(name = "primary_key_a", length = 50)
	private String primaryKeyA; 
        
        @Column(name = "primary_key_b", length = 50)
	private String primaryKeyB;
        
        @Column(name = "secondary_key_a", length = 50)
	private String secondaryKeyA;
        
        @Column(name = "secondary_key_b", length = 50)
	private String secondaryKeyB;
        
         @Column (name = "installation_date")
	private Date installationDate;

    public Sensor() {
    }

    public Sensor( String primaryPurpleairId, String secondaryPurpleairId, String displayName, String primaryChannelA, String primaryChannelB, String secondaryChannelA, String secondaryChannelB, String primaryKeyA, String primaryKeyB, String secondaryKeyA, String secondaryKeyB, Date installation_date) {
        
        this.primaryPurpleairId = primaryPurpleairId;
        this.secondaryPurpleairId = secondaryPurpleairId;
        this.displayName = displayName;
        this.primaryChannelA = primaryChannelA;
        this.primaryChannelB = primaryChannelB;
        this.secondaryChannelA = secondaryChannelA;
        this.secondaryChannelB = secondaryChannelB;
        this.primaryKeyA = primaryKeyA;
        this.primaryKeyB = primaryKeyB;
        this.secondaryKeyA = secondaryKeyA;
        this.secondaryKeyB = secondaryKeyB;
        this.installationDate = installation_date;
    }

        @Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "sensor_gen")
	@Column (name = "id", columnDefinition = "bigserial", insertable = true, updatable = true, unique = true)
	private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrimaryPurpleairId() {
        return primaryPurpleairId;
    }

    public void setPrimaryPurpleairId(String primaryPurpleairId) {
        this.primaryPurpleairId = primaryPurpleairId;
    }

    public String getSecondaryPurpleairId() {
        return secondaryPurpleairId;
    }

    public void setSecondaryPurpleairId(String secondaryPurpleairId) {
        this.secondaryPurpleairId = secondaryPurpleairId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getPrimaryChannelA() {
        return primaryChannelA;
    }

    public void setPrimaryChannelA(String primaryChannelA) {
        this.primaryChannelA = primaryChannelA;
    }

    public String getPrimaryChannelB() {
        return primaryChannelB;
    }

    public void setPrimaryChannelB(String primaryChannelB) {
        this.primaryChannelB = primaryChannelB;
    }

    public String getSecondaryChannelA() {
        return secondaryChannelA;
    }

    public void setSecondaryChannelA(String secondaryChannelA) {
        this.secondaryChannelA = secondaryChannelA;
    }

    public String getSecondaryChannelB() {
        return secondaryChannelB;
    }

    public void setSecondaryChannelB(String secondaryChannelB) {
        this.secondaryChannelB = secondaryChannelB;
    }

    public String getPrimaryKeyA() {
        return primaryKeyA;
    }

    public void setPrimaryKeyA(String primaryKeyA) {
        this.primaryKeyA = primaryKeyA;
    }

    public String getPrimaryKeyB() {
        return primaryKeyB;
    }

    public void setPrimaryKeyB(String primaryKeyB) {
        this.primaryKeyB = primaryKeyB;
    }

    public String getSecondaryKeyA() {
        return secondaryKeyA;
    }

    public void setSecondaryKeyA(String secondaryKeyA) {
        this.secondaryKeyA = secondaryKeyA;
    }

    public String getSecondaryKeyB() {
        return secondaryKeyB;
    }

    public void setSecondaryKeyB(String secondaryKeyB) {
        this.secondaryKeyB = secondaryKeyB;
    }

    public Date getInstallation_date() {
        return installationDate;
    }

    public void setInstallation_date(Date installation_date) {
        this.installationDate = installation_date;
    }
         
         
        
        
}
