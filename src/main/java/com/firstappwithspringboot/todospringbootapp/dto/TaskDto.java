package com.firstappwithspringboot.todospringbootapp.dto;

import com.firstappwithspringboot.todospringbootapp.entities.EnnumState;
import com.firstappwithspringboot.todospringbootapp.entities.Project;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

public class TaskDto {

    private String taskName;
    private String taskDescription;
    private LocalDateTime taskDateBegin;
    private Integer duration;
    private EnnumState state;
    private Project project;

    public TaskDto() {}

    public TaskDto(String taskName, String taskDescription, LocalDateTime taskDateBegin, Integer duration, EnnumState state, Project project) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskDateBegin = taskDateBegin;
        this.duration = duration;
        this.state = state;
        this.project = project;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public LocalDateTime getTaskDateBegin() {
        return taskDateBegin;
    }

    public void setTaskDateBegin(LocalDateTime taskDateBegin) {
        this.taskDateBegin = taskDateBegin;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public EnnumState getState() {
        return state;
    }

    public void setState(EnnumState state) {
        this.state = state;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

}
