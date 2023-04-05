package com.sda.onlinestore.repository;

import com.sda.onlinestore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //Userr findByEmail(String email);
    Optional<User> findByEmail(String email);
}
