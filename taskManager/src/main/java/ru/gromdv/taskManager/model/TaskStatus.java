package ru.gromdv.taskManager.model;


import lombok.Getter;

@Getter
public enum TaskStatus {
    NEW_TASK ("Новая"),
    IN_PROGRESS ("В работе"),
    PAUSED ("Остановлена"),
    CANCELED ("Отменена"),
    COMPLETED ("Выполнена"),
    URGENT ("Срочная");

    private final String title;

    TaskStatus(String title) {
        this.title = title;
    }
}