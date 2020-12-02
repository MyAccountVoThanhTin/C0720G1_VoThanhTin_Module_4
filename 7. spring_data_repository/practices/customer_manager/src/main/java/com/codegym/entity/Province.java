package com.codegym.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "province")
public class Province {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_province;
    private String name_province;

    @OneToMany(mappedBy = "province",cascade = CascadeType.ALL)
    private Set<Customer> customerSet;

    public Province() {
    }

    public int getId_province() {
        return id_province;
    }

    public void setId_province(int id_province) {
        this.id_province = id_province;
    }

    public String getName_province() {
        return name_province;
    }

    public void setName_province(String name_province) {
        this.name_province = name_province;
    }

    public Set<Customer> getCustomerSet() {
        return customerSet;
    }

    public void setCustomerSet(Set<Customer> customerSet) {
        this.customerSet = customerSet;
    }
}
