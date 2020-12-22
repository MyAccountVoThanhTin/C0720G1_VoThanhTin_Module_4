package com.codegym.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleId;
    @Column(columnDefinition = "VARCHAR(255)")
    private String roleName;
    @OneToOne(mappedBy = "role",cascade = CascadeType.ALL)
    private User user;
    public Role() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role(String role_name) {
        this.roleName = role_name;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int role_id) {
        this.roleId = role_id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String role_name) {
        this.roleName = role_name;
    }
}
