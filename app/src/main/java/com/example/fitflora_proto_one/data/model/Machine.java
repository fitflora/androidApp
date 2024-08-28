package com.example.fitflora_proto_one.data.model;

public class Machine {

    private String id;
    private String name;
    private String qrCode;
    private String status;
    private Product product;

    // Constructor
    public Machine(String id, String name, String qrCode, String status, Product product) {
        this.id = id;
        this.name = name;
        this.qrCode = qrCode;
        this.status = status;
        this.product = product;
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

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
