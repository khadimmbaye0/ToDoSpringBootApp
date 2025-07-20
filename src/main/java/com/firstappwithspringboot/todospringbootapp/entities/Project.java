package com.firstappwithspringboot.todospringbootapp.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "project")
public class Project extends CalculusMethod {

    @Id
    @GeneratedValue
    private Integer idProject;

    @NotEmpty
    private String projectName;

    private String projectDescription;

    @NotNull
    private LocalDateTime projectBeginDate;

    @NotNull
    private Integer duration;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "project")
    private List<Task> tasks;

    public Project() {}

    public Project(String projectName, String projectDescription, LocalDateTime projectBeginDate, Integer duration) {
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.projectBeginDate = projectBeginDate;
        this.duration = duration;
    }

    public Integer getIdProject() {
        return idProject;
    }

    public void setIdProject(Integer idProject) {
        this.idProject = idProject;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public LocalDateTime getProjectBeginDate() {
        return projectBeginDate;
    }

    public void setProjectBeginDate(LocalDateTime projectBeginDate) {
        this.projectBeginDate = projectBeginDate;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

}