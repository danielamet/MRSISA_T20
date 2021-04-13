package com.isamrs.backend.repository;

import com.isamrs.backend.model.Authority;
import com.isamrs.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    Authority findByUser(User user);
}
