package com.ownai.e2e.repo;

import com.ownai.e2e.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepo extends JpaRepository<Login, Long> {
    Login findByUsername(String username);
}
