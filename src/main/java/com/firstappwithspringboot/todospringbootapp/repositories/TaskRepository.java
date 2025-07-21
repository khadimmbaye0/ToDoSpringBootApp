package com.firstappwithspringboot.todospringbootapp.repositories;

import com.firstappwithspringboot.todospringbootapp.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

}
