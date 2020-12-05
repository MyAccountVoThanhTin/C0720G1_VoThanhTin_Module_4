package com.codegym.service;

import com.codegym.entity.Login;

public interface LoginService {
    Login findByName(String userName);
}
