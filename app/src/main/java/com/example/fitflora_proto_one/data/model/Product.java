package com.example.fitflora_proto_one.data.model;

public class Product {

    private String productName;
    private String description;
    private String productImg;
    private String waterNeeded;
    private String sunlightNeeded;
    private int aveHeight;
    private String origin;
    private String lifecycle;
    private float calories;
    private float protein;
    private String vitaminOneName;
    private String vitaminTwoName;
    private float vitaminOneVal;
    private float vitaminTwoVal;
    private String mineralOneName;
    private String mineralTwoName;
    private float mineralOneVal;
    private float mineralTwoVal;

    // Constructor
    public Product(String productName, String description, String productImg, String waterNeeded, String sunlightNeeded,
                   int aveHeight, String origin, String lifecycle, float calories, float protein,
                   String vitaminOneName, String vitaminTwoName, float vitaminOneVal, float vitaminTwoVal,
                   String mineralOneName, String mineralTwoName, float mineralOneVal, float mineralTwoVal) {
        this.productName = productName;
        this.description = description;
        this.productImg = productImg;
        this.waterNeeded = waterNeeded;
        this.sunlightNeeded = sunlightNeeded;
        this.aveHeight = aveHeight;
        this.origin = origin;
        this.lifecycle = lifecycle;
        this.calories = calories;
        this.protein = protein;
        this.vitaminOneName = vitaminOneName;
        this.vitaminTwoName = vitaminTwoName;
        this.vitaminOneVal = vitaminOneVal;
        this.vitaminTwoVal = vitaminTwoVal;
        this.mineralOneName = mineralOneName;
        this.mineralTwoName = mineralTwoName;
        this.mineralOneVal = mineralOneVal;
        this.mineralTwoVal = mineralTwoVal;
    }

    // Getters and Setters

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    public String getWaterNeeded() {
        return waterNeeded;
    }

    public void setWaterNeeded(String waterNeeded) {
        this.waterNeeded = waterNeeded;
    }

    public String getSunlightNeeded() {
        return sunlightNeeded;
    }

    public void setSunlightNeeded(String sunlightNeeded) {
        this.sunlightNeeded = sunlightNeeded;
    }

    public int getAveHeight() {
        return aveHeight;
    }

    public void setAveHeight(int aveHeight) {
        this.aveHeight = aveHeight;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getLifecycle() {
        return lifecycle;
    }

    public void setLifecycle(String lifecycle) {
        this.lifecycle = lifecycle;
    }

    public float getCalories() {
        return calories;
    }

    public void setCalories(float calories) {
        this.calories = calories;
    }

    public float getProtein() {
        return protein;
    }

    public void setProtein(float protein) {
        this.protein = protein;
    }

    public String getVitaminOneName() {
        return vitaminOneName;
    }

    public void setVitaminOneName(String vitaminOneName) {
        this.vitaminOneName = vitaminOneName;
    }

    public String getVitaminTwoName() {
        return vitaminTwoName;
    }

    public void setVitaminTwoName(String vitaminTwoName) {
        this.vitaminTwoName = vitaminTwoName;
    }

    public float getVitaminOneVal() {
        return vitaminOneVal;
    }

    public void setVitaminOneVal(float vitaminOneVal) {
        this.vitaminOneVal = vitaminOneVal;
    }

    public float getVitaminTwoVal() {
        return vitaminTwoVal;
    }

    public void setVitaminTwoVal(float vitaminTwoVal) {
        this.vitaminTwoVal = vitaminTwoVal;
    }

    public String getMineralOneName() {
        return mineralOneName;
    }

    public void setMineralOneName(String mineralOneName) {
        this.mineralOneName = mineralOneName;
    }

    public String getMineralTwoName() {
        return mineralTwoName;
    }

    public void setMineralTwoName(String mineralTwoName) {
        this.mineralTwoName = mineralTwoName;
    }

    public float getMineralOneVal() {
        return mineralOneVal;
    }

    public void setMineralOneVal(float mineralOneVal) {
        this.mineralOneVal = mineralOneVal;
    }

    public float getMineralTwoVal() {
        return mineralTwoVal;
    }

    public void setMineralTwoVal(float mineralTwoVal) {
        this.mineralTwoVal = mineralTwoVal;
    }
}