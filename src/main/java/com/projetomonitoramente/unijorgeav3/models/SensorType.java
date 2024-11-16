package com.projetomonitoramente.unijorgeav3.models;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class SensorType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String units;

    @OneToMany(mappedBy = "sensorType", cascade = CascadeType.ALL)
    private List<Sensor> sensors = new ArrayList<>();

    public SensorType() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public List<Sensor> getSensors() {
        return sensors;
    }

    public void setSensors(List<Sensor> sensors) {
        this.sensors = sensors;
    }
}
