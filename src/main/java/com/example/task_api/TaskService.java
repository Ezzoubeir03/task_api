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
      ///this the DTO(Data Transfer Object)
    public Task updateTask(Long id, Task task){
        Task existingTask = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not Found"));
        existingTask.setTitle(task.getTitle());
        existingTask.setCompleted(task.isCompleted());
        return taskRepository.save(existingTask);
    }
    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }
}
