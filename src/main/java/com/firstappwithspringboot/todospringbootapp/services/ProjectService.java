package com.firstappwithspringboot.todospringbootapp.services;

import com.firstappwithspringboot.todospringbootapp.entities.Project;
import com.firstappwithspringboot.todospringbootapp.repositories.ProjectRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final UserService userService;

    public ProjectService(UserService userService, ProjectRepository projectRepository) {
        this.userService = userService;
        this.projectRepository = projectRepository;
    }

    public Project createProjectForUser(Project prj, Integer userId) {
        var user = userService.findUserById(userId);
        prj.setUser(user);
        return projectRepository.save(prj);
    }

    public List<Project> getAllProjects() {
        List<Project> projects = projectRepository.findAll();
        if (projects.isEmpty()){
            System.out.println("No project found");
            return null;
        }
        return projects;
    }

    public Project findProjectById(Integer id) {
        Optional<Project> prj = projectRepository.findById(id);
        if (prj.isPresent()) {
            return prj.get();
        }
        System.out.println("Project not found");
        return null;
    }

    public void deleteProject(Integer idPrj) {
        var prj = findProjectById(idPrj);
        if (prj != null) {
            projectRepository.deleteById(idPrj);
            System.out.println("project deleted successfully");
        }
        else {
            System.out.println("project not found");
        }
    }

    public Project updateDuration(Integer idPrj, Integer newDuration) {
        var prj = findProjectById(idPrj);
        if (prj != null) {
            prj.setDuration(newDuration);
            return projectRepository.save(prj);
        }
        System.out.println("Project not found");
        return null;
    }

    public List<Project> getAllProjectForUser(Integer idUser) {
        var user = userService.findUserById(idUser);
        if (user != null) {
            List<Project> projects = projectRepository.findByUser(userService.findUserById(idUser));
            if (projects.isEmpty()) {
                System.out.println("Not project found for user: " + idUser);
                return null;
            }
            return projects;
        }
        System.out.println("User not found");
        return null;
    }

    public LocalDateTime getFinishProjectDate(Integer projectId) {
        var prj = findProjectById(projectId);
        if (prj != null) {
            return prj.getFinihDate(prj.getProjectBeginDate(), prj.getDuration());
        }
        System.out.println("Error");
        return null;
    }

}
