package com.firstappwithspringboot.todospringbootapp.repositories;

import com.firstappwithspringboot.todospringbootapp.entities.Project;
import com.firstappwithspringboot.todospringbootapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
    List<Project> findByUser(User user);
}