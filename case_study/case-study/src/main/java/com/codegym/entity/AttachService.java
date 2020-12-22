package com.codegym.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity(name = "attach_service")
public class AttachService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int attachServiceId;
    @Column(columnDefinition = "VARCHAR(45)")
    private String attachServiceName;
    private double attachServiceCost;
    private int attachServiceUnit;
    @Column(columnDefinition = "VARCHAR(45)")
    private String attachServiceStatus;
    @OneToMany(mappedBy = "attachService",cascade = CascadeType.ALL)
    @JsonBackReference
    private List<ContractDetails> contractDetailsList;
    public AttachService() {
    }

    public AttachService(String attachServiceName, double attachServiceCost, int attachServiceUnit, String attachServiceStatus) {
        this.attachServiceName = attachServiceName;
        this.attachServiceCost = attachServiceCost;
        this.attachServiceUnit = attachServiceUnit;
        this.attachServiceStatus = attachServiceStatus;
    }

    public List<ContractDetails> getContractDetailsList() {
        return contractDetailsList;
    }

    public void setContractDetailsList(List<ContractDetails> contractDetailsList) {
        this.contractDetailsList = contractDetailsList;
    }

    public int getAttachServiceId() {
        return attachServiceId;
    }

    public void setAttachServiceId(int attachServiceId) {
        this.attachServiceId = attachServiceId;
    }

    public String getAttachServiceName() {
        return attachServiceName;
    }

    public void setAttachServiceName(String attachServiceName) {
        this.attachServiceName = attachServiceName;
    }

    public double getAttachServiceCost() {
        return attachServiceCost;
    }

    public void setAttachServiceCost(double attachServiceCost) {
        this.attachServiceCost = attachServiceCost;
    }

    public int getAttachServiceUnit() {
        return attachServiceUnit;
    }

    public void setAttachServiceUnit(int attachServiceUnit) {
        this.attachServiceUnit = attachServiceUnit;
    }

    public String getAttachServiceStatus() {
        return attachServiceStatus;
    }

    public void setAttachServiceStatus(String attachServiceStatus) {
        this.attachServiceStatus = attachServiceStatus;
    }
}
