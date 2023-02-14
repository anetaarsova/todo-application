package com.example.todoapplication;

import com.example.todoapplication.domain.tasks.model.Task;
import com.example.todoapplication.domain.tasks.repository.TaskRepository;
import com.example.todoapplication.domain.tasks.service.TaskService;
import org.junit.ClassRule;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

import javax.sql.DataSource;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Testcontainers
class TodoApplicationTests {

    @Autowired
    private MockMvc mockMvc;
    @ClassRule
    public static PostgreSQLContainer postgreSQLContainer = TodoPostgresContainer.getInstance();
    @Test
    void contextLoads() {
    }

    @Test
    void listAllTasks() {
        var service = new TaskService();

        List<Task> tasks = service.listTasks();

        assertEquals(tasks,null);
    }
    @Test
    public void getAllTasks() throws Exception {
        this.mockMvc.perform(get("http://localhost:8080/api/tasks")).andDo(print()).andExpect(status().isOk())
                .andExpect((ResultMatcher) content().string("[{\"id\":1]"));
    }

    @Test
    public void getTaskById() throws Exception {
        this.mockMvc.perform(get("http://localhost:8080/api/tasks/{d}")).andDo(print()).andExpect(status().isOk())
                .andExpect((ResultMatcher) content().string("[{\"id\":1]"));
    }

}
