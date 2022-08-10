package com.ownai.e2e.service;

import com.ownai.e2e.model.RegisteredUser;
import com.ownai.e2e.repo.RegisteredUserRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegisteredUserService {

    private final RegisteredUserRepo registeredUserRepo;

    public RegisteredUserService(RegisteredUserRepo registeredUserRepo) {
        this.registeredUserRepo = registeredUserRepo;
    }

    public RegisteredUser findByEmail(String email){
        return registeredUserRepo.findByEmail(email);
    }

    public RegisteredUser findOne(){
        Optional<RegisteredUser> optional = registeredUserRepo.findAll().stream().findFirst();
        return optional.get();
    }
}
