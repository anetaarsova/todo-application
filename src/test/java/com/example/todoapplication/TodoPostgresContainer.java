package com.example.todoapplication;

import org.testcontainers.containers.PostgreSQLContainer;

public class TodoPostgresContainer extends PostgreSQLContainer<TodoPostgresContainer> {

    private static final String IMAGE_VERSION = "postgres:15.1";
    private static TodoPostgresContainer container;

    private TodoPostgresContainer() {
        super(IMAGE_VERSION);
    }

    public static TodoPostgresContainer getInstance() {
        if (container == null) {
            container = new TodoPostgresContainer();
        }
        return container;
    }

    @Override
    public void start() {
        super.start();
        System.setProperty("DB_URL", container.getJdbcUrl());
        System.setProperty("DB_USERNAME", container.getUsername());
        System.setProperty("DB_PASSWORD", container.getPassword());
    }

    @Override
    public void stop() {
        //do nothing, JVM handles shut down
    }
}