package com.ownai.e2e.service;

import com.ownai.e2e.model.Login;
import com.ownai.e2e.repo.LoginRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    private final LoginRepo loginRepo;

    public LoginService(LoginRepo loginRepo) {
        this.loginRepo = loginRepo;
    }

    public Login findByUsername(String username){
        return loginRepo.findByUsername(username);
    }

    public  Login findByOne(){
       Optional<Login> optional = loginRepo.findAll().stream().findAny();
       return optional.get();
    }
}
