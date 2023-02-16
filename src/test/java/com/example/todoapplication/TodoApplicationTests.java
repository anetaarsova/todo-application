package com.example.todoapplication;

import com.example.todoapplication.domain.tasks.TaskController;
import com.example.todoapplication.domain.tasks.model.Task;
import com.example.todoapplication.domain.tasks.service.TaskService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.Collections;
import java.util.List;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@AutoConfigureMockMvc
@Testcontainers(disabledWithoutDocker = true)
class TodoApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskController taskController;
    @Container
    private static final PostgreSQLContainer POSTGRES_SQL_CONTAINER = new PostgreSQLContainer("postgres:latest");


    @BeforeAll
    static void setUp() {
        POSTGRES_SQL_CONTAINER.start();
    }

    @AfterAll
    static void tearDown() {
        POSTGRES_SQL_CONTAINER.close();
        assertThat(POSTGRES_SQL_CONTAINER.isRunning()).isFalse();
    }

    @BeforeEach
    void testIsContainerRunning() {
        assertThat(POSTGRES_SQL_CONTAINER.isRunning()).isTrue();
    }

    @Test
    void contextLoads() {
        assertThat(taskService).isNotNull();
        assertThat(taskController).isNotNull();
    }

    @Test
    void listAllTasks() {

        List<Task> tasks = taskService.listTasks();

        assertEquals(tasks, Collections.EMPTY_LIST);
    }

    @Test
    void getAllTasks() throws Exception {
        var task = new Task();
        task.setId(1L);
        taskService.saveOrUpdate(task);
        this.mockMvc.perform(get("/api/tasks")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void getTaskById() throws Exception {
        var task = new Task();

        var output = taskService.saveOrUpdate(task);
        assertThat(output).isNotNull();
        assertThat(output.getId()).isNotNull();
        mockMvc.perform(get("/api/tasks/"+output.getId())).andDo(print()).andExpect(status().isOk());
    }

}
