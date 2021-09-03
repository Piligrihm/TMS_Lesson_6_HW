package com.tms.exception;

public class ContainSequanceException extends Exception {
    public ContainSequanceException() {
    }
    /**
     * Конструктор
     * @param message - принимает на вход строку
     */
    public ContainSequanceException(String message) {
        super(message);
    }
}
