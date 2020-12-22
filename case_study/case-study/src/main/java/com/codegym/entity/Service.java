package com.codegym.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity(name = "service")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int serviceId;
    @Column(columnDefinition = "VARCHAR(45)")
    private String serviceName;
    private int serviceArea;
    private double serviceCost;
    private int serviceMaxPeople;
    @Column(columnDefinition = "VARCHAR(45)")
    private String standardRoom;
    @Column(columnDefinition = "VARCHAR(45)")
    private String descriptonOrtherConvinience;
    private double poolArea;
    private int numberOfFloor;
    @ManyToOne
    @JoinColumn(name = "id_serviceType",referencedColumnName = "serviceTypeId")
    private ServiceType serviceType;
    @ManyToOne
    @JoinColumn(name = "id_rentType",referencedColumnName = "rentTypeId")
    private RentType rentType;
    @OneToMany(mappedBy = "service",cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Contract> contractList;
    public Service() {
    }
    public Service(String serviceName, int serviceArea, double serviceCost, int serviceMaxPeople, int rentTypeId, int serviceTypeId, String standardRoom, String descriptonOrtherConvinience, double poolArea, int numberOfFloor) {
        this.serviceName = serviceName;
        this.serviceArea = serviceArea;
        this.serviceCost = serviceCost;
        this.serviceMaxPeople = serviceMaxPeople;
        this.standardRoom = standardRoom;
        this.descriptonOrtherConvinience = descriptonOrtherConvinience;
        this.poolArea = poolArea;
        this.numberOfFloor = numberOfFloor;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(int serviceArea) {
        this.serviceArea = serviceArea;
    }

    public double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public int getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(int serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptonOrtherConvinience() {
        return descriptonOrtherConvinience;
    }

    public void setDescriptonOrtherConvinience(String descriptonOrtherConvinience) {
        this.descriptonOrtherConvinience = descriptonOrtherConvinience;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }
}
