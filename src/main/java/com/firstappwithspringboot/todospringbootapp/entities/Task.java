package com.firstappwithspringboot.todospringbootapp.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "task")
public class Task extends CalculusMethod {

    @Id
    @GeneratedValue
    private Integer idTask;

    @NotEmpty
    private String taskName;

    private String taskDescription;

    @NotNull
    private LocalDateTime taskDateBegin;

    @NotNull
    private Integer duration;

    @Enumerated(EnumType.STRING)
    private EnnumState state;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    public Task() {}

    public Task(String taskName, String taskDescription, LocalDateTime taskDateBegin, Integer duration, EnnumState state, Project project) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskDateBegin = taskDateBegin;
        this.duration = duration;
        this.state = state;
        this.project = project;
    }

    public Integer getIdTask() {
        return idTask;
    }

    public void setIdTask(Integer idTask) {
        this.idTask = idTask;
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