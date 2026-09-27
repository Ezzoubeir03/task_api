package com.example.task_api;

import org.springframework.stereotype.Service;

@Service 

public class TaskService {
    

    public Task createTask(Task task){
        

        if(task.getTitle() == null || task.getTitle().isBlank()){
            throw new IllegalArgumentException("Task title cannot be null or empty.");

        }
        task.setCompleted(false);
        return task;
    }
}
