package com.sda.onlinestore.repository;

import com.sda.onlinestore.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, String> {


}
