package ru.gromdv.webService.dto;

import lombok.Getter;

@Getter
public enum MessageStatus {
    UNREAD_MESS ("Новое"),
    IMPORTANT_MESS ("Важное"),
    ORDINARY_MESS ("Обычное"),
    MARKED_MESS ("Помеченое"),
    ARCHIVED_MESS ("Архивированное");

    private final String title;

    MessageStatus(String title) {
        this.title = title;
    }
}