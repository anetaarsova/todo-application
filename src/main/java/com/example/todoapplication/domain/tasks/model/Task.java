package com.example.todoapplication.domain.tasks.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Entity
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Task implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String caption;
    @Column
    private String content;
    @Column
    private boolean completed;

    public Task() {

    }

    public void setId(Long id) {
        this.id = id;
    }

//    public Long getId() {
//        return id;
//    }
//
//    @Override
//    public String toString() {
//        return "Task{" +
//                "id=" + id +
//                '}';
//    }
}
