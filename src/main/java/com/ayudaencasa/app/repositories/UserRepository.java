package com.ayudaencasa.app.repositories;

import com.ayudaencasa.app.entities.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String>{
    
    Optional<User> findByEmail(String email);
}
