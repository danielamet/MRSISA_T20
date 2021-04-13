package com.isamrs.backend.repository;

import com.isamrs.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String email);
    User findByEmailAndPassword(String email,String password);
}
