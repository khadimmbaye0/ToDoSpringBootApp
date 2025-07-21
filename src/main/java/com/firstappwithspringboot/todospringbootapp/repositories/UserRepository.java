package com.firstappwithspringboot.todospringbootapp.repositories;

import com.firstappwithspringboot.todospringbootapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
