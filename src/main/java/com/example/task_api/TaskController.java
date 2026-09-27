package com.example.task_api;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/tasks")

public class TaskController {


    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestBody Task task){
        return taskService.createTask(task);
    }
}
