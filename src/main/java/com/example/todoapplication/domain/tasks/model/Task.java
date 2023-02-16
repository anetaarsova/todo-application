package com.example.todoapplication.domain.tasks.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = true)
    private String caption;
    @Column(nullable = true)
    private String content;
    @Column(nullable = true)
    private boolean completed;
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                '}';
    }
}
