package com.codegym.entity;

import javax.persistence.*;

@Entity(name = "contract_detail")
public class ContractDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contractDetailId;
    private int contractId;
    private int attachServiceId;
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "id_attachService",referencedColumnName = "attachServiceId")
    private AttachService attachService;
    @ManyToOne
    @JoinColumn(name = "id_contract",referencedColumnName = "contractId")
    private Contract contract;
    public ContractDetails() {
    }

    public ContractDetails(int contractId, int attachServiceId, int quantity) {
        this.contractId = contractId;
        this.attachServiceId = attachServiceId;
        this.quantity = quantity;
    }

    public ContractDetails(int contractDetailId, AttachService attachService, Contract contract) {
        this.contractDetailId = contractDetailId;
        this.attachService = attachService;
        this.contract = contract;
    }

    public int getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(int contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public int getAttachServiceId() {
        return attachServiceId;
    }

    public void setAttachServiceId(int attachServiceId) {
        this.attachServiceId = attachServiceId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
