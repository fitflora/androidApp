package com.example.fitflora_proto_one.data.model;

import java.util.List;

public class Tree {

    private String id;
    private String name;
    private String location;
    private float distance;
    private List<Machine> machines;

    public Tree(String id, String name, String location, float distance, List<Machine> machines) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.distance = distance;
        this.machines = machines;
    }

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public List<Machine> getMachines() {
        return machines;
    }

    public void setMachines(List<Machine> machines) {
        this.machines = machines;
    }
}
