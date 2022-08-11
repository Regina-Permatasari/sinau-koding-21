package com.sinaukoding21.tugas6.repository;

import com.sinaukoding21.tugas6.model.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<user, Integer> {
    user findByUsername(String username);
}
