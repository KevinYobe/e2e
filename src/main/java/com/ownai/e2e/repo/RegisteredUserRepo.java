package com.ownai.e2e.repo;

import com.ownai.e2e.model.RegisteredUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisteredUserRepo extends JpaRepository<RegisteredUser, Long> {
    RegisteredUser findByEmail(String email);
}
