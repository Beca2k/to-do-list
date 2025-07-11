package com.rebeca.todolist.entity.service.constant;

public enum TaskStatus {

    PENDENTE(0, "Pendente"), CONCLUIDO(1, "Concluído");

    private final int code;
    private final String description;

    TaskStatus(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static TaskStatus fromCode(int code) {
        for (TaskStatus status : values()) {
            if (status.code == code) {
                return status;
            }
        }
        return PENDENTE;
    }

    public static TaskStatus fromDescription(String description) {
        for (TaskStatus status : values()) {
            if (status.description.equalsIgnoreCase(description)) {
                return status;
            }
        }
        return PENDENTE;
    }
}

