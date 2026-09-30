package com.example.task_api;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.task_api.repository.TaskRepository;

@Service 
public class TaskService {
    private final TaskRepository taskRepository;
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }
    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }
     
    public Task createTask(Task task){
           

        if(task.getTitle() == null || task.getTitle().isBlank()){
            throw new IllegalArgumentException("Task title cannot be null or empty.");

        }
        task.setCompleted(false);
        return taskRepository.save(task);
    }
}
