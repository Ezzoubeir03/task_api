package com.example.task_api;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity 
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private  String title; //"hello" 
    private Boolean completed;  

    public Task() { // constructor 
    }
    public Task createTask(TaskRequest request){
        if(request.getTitle() == null || request.getTitle().isBlank()){
            throw new IllegalArgumentException("Task title cannot be null or empty.");
        }

        Task task2 = new Task();

        task2.setTitle(request.getTitle());
        task2.setCompleted(false);
        return task2;
    }

class TaskRequest {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
        public Task(Long id, String title, Boolean completed){ // constructor with paramiter
            this.id = id;
            this.title = title;
            this.completed = completed;
        }

        public Long getId() {
            return id;
        }
        public void setId(Long id){
            this.id = id;

        }
        public String getTitle() {
            return title;
        }
        public void setTitle(String title ){
            this.title = title;
        }
        public Boolean isCompleted() {
            return completed;
        }

        public void setCompleted(Boolean completed){
            this.completed = completed;
        }
    }
