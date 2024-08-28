package com.example.fitflora_proto_one.data.model;

import java.sql.Timestamp;
import java.util.List;

public class SessionTree {

    private String machineId;
    private String userId;
    private String sessionId;
    private Timestamp createdAt;
    private Timestamp endedAt;
    private List<Float> sensorData;
    private int plantHealthPoints;
    private float waterGiven;
    private float lightExposed;
    private float plantGrowth;
    private float energySaved;
    private float waterConserved;
    private float co2Reduced;
    private float caloriesBurnt;
    private String workoutType;

    // Constructor
    public SessionTree(String machineId, String userId, String sessionId, Timestamp createdAt, Timestamp endedAt,
                       List<Float> sensorData, int plantHealthPoints, float waterGiven, float lightExposed,
                       float plantGrowth, float energySaved, float waterConserved, float co2Reduced,
                       float caloriesBurnt, String workoutType) {
        this.machineId = machineId;
        this.userId = userId;
        this.sessionId = sessionId;
        this.createdAt = createdAt;
        this.endedAt = endedAt;
        this.sensorData = sensorData;
        this.plantHealthPoints = plantHealthPoints;
        this.waterGiven = waterGiven;
        this.lightExposed = lightExposed;
        this.plantGrowth = plantGrowth;
        this.energySaved = energySaved;
        this.waterConserved = waterConserved;
        this.co2Reduced = co2Reduced;
        this.caloriesBurnt = caloriesBurnt;
        this.workoutType = workoutType;
    }

    // Getters and Setters

    public String getMachineId() {
        return machineId;
    }

    public void setMachineId(String machineId) {
        this.machineId = machineId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getEndedAt() {
        return endedAt;
    }

    public void setEndedAt(Timestamp endedAt) {
        this.endedAt = endedAt;
    }

    public List<Float> getSensorData() {
        return sensorData;
    }

    public void setSensorData(List<Float> sensorData) {
        this.sensorData = sensorData;
    }

    public int getPlantHealthPoints() {
        return plantHealthPoints;
    }

    public void setPlantHealthPoints(int plantHealthPoints) {
        this.plantHealthPoints = plantHealthPoints;
    }

    public float getWaterGiven() {
        return waterGiven;
    }

    public void setWaterGiven(float waterGiven) {
        this.waterGiven = waterGiven;
    }

    public float getLightExposed() {
        return lightExposed;
    }

    public void setLightExposed(float lightExposed) {
        this.lightExposed = lightExposed;
    }

    public float getPlantGrowth() {
        return plantGrowth;
    }

    public void setPlantGrowth(float plantGrowth) {
        this.plantGrowth = plantGrowth;
    }

    public float getEnergySaved() {
        return energySaved;
    }

    public void setEnergySaved(float energySaved) {
        this.energySaved = energySaved;
    }

    public float getWaterConserved() {
        return waterConserved;
    }

    public void setWaterConserved(float waterConserved) {
        this.waterConserved = waterConserved;
    }

    public float getCo2Reduced() {
        return co2Reduced;
    }

    public void setCo2Reduced(float co2Reduced) {
        this.co2Reduced = co2Reduced;
    }

    public float getCaloriesBurnt() {
        return caloriesBurnt;
    }

    public void setCaloriesBurnt(float caloriesBurnt) {
        this.caloriesBurnt = caloriesBurnt;
    }

    public String getWorkoutType() {
        return workoutType;
    }

    public void setWorkoutType(String workoutType) {
        this.workoutType = workoutType;
    }
}