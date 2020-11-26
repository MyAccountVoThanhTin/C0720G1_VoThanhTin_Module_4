package com.codegym.model;

public class Product {
    private int id;
    private String name;
    private String nsx;
    private String address;

    public Product() {
    }

    public Product(int id, String name, String nsx, String address) {
        this.id = id;
        this.name = name;
        this.nsx = nsx;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNsx() {
        return nsx;
    }

    public void setNsx(String nsx) {
        this.nsx = nsx;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
