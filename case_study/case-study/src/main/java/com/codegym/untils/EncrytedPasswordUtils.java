package com.codegym.untils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncrytedPasswordUtils {
    public static String encrytePassword(String pass){
        return new BCryptPasswordEncoder().encode(pass);
    }

    public static void main(String[] args) {
        String password = "123456";
        String encrytedPassword = encrytePassword(password);
        System.out.println("Encryted Password: " + encrytedPassword);
    }
}
