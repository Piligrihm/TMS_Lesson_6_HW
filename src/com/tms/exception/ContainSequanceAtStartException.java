package com.tms.exception;

public class ContainSequanceAtStartException extends Exception {
    public ContainSequanceAtStartException() {
    }

    /**
     * Конструктор
     * @param message - принимает на вход строку
     */
    public ContainSequanceAtStartException(String message) {
        super(message);
    }
}
