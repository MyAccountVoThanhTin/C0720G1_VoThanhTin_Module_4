package com.codegym.untils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncrytedPasswordUtils {

    public static String encrytePassword(String pass){
        return new BCryptPasswordEncoder().encode(pass);
    }

    public static void main(String[] args) {
        System.out.println("Encryted Password: " + encrytePassword("123"));
    }
}
