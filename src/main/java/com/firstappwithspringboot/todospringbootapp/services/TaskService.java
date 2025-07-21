package com.firstappwithspringboot.todospringbootapp.services;

import com.firstappwithspringboot.todospringbootapp.entities.EnnumState;
import com.firstappwithspringboot.todospringbootapp.entities.Task;
import com.firstappwithspringboot.todospringbootapp.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TaskService {

    private final ProjectService projectService;
    private final TaskRepository taskRepository;

    public TaskService(ProjectService projectService, TaskRepository taskRepository) {
        this.projectService = projectService;
        this.taskRepository = taskRepository;
    }

    public Task addNewTaskToAProject(Task task, Integer idPrj) {
        var prj = projectService.findProjectById(idPrj);
        if (prj != null) {
            task.setProject(prj);
            return taskRepository.save(task);
        }
        System.out.println("No project found");
        return null;
    }

    public Task findTaskById(Integer idTask) {
        Optional<Task> task = taskRepository.findById(idTask);
        if (task.isPresent()) {
            return task.get();
        }
        System.out.println("No task found");
        return null;
    }

    public Task updateTaskState(Integer taskId, EnnumState taskState) {
        var task = findTaskById(taskId);
        if (task != null) {
            task.setState(taskState);
            return taskRepository.save(task);
        }
        System.out.println("Error");
        return null;
    }

    public LocalDateTime getFinishDateTask(Integer taskId) {
        var task = findTaskById(taskId);
        return task.getFinihDate(task.getTaskDateBegin(), task.getDuration());
    }

}
