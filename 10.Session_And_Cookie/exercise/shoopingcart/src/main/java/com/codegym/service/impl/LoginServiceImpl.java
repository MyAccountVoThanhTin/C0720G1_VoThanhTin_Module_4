package com.codegym.service.impl;

import com.codegym.entity.Login;
import com.codegym.repository.LoginRepository;
import com.codegym.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginRepository loginRepository;

    @Override
    public Login findByName(String userName) {
        return loginRepository.findByUserName(userName);
    }
}
