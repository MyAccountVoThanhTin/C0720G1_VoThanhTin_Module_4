package com.codegym.entity;

import javax.persistence.*;

@Entity(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_age")
    private String userAge;
    @Column(name = "user_address")
    private String userAddress;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shooping_cart_id",nullable = false,referencedColumnName = "cart_id")
    private ShoppingCart shoppingCart;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "user")
    private Login login;

    public User() {
    }


    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
}
