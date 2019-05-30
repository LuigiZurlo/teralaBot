/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
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
@Table(name = "parameter2", schema = "raw_data_test")
@SequenceGenerator(name = "parameter2_gen", sequenceName = "parameter2_id_seq", allocationSize = 1)
public class Parameter2 implements Serializable {

    private static final long serialVersionUID = -8211695100936100048L;
//    private static final long serialVersionUID = ObjectStreamClass.lookup(Location.class).getSerialVersionUID();   

    @Column(name = "code", length = 50)
    private String code;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "description", length = 200)
    private String description;

    @Column(name = "unit", length = 200)
    private String unit;

    public Parameter2() {
    }

    public Parameter2(String code, String name, String description, String unit) {

        this.code = code;
        this.name = name;
        this.description = description;
        this.unit = unit;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "parameter2_gen")
    @Column(name = "id", columnDefinition = "bigserial", insertable = true, updatable = true, unique = true)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

}
