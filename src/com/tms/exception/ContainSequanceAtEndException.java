package com.tms.exception;

public class ContainSequanceAtEndException extends Exception {
    public ContainSequanceAtEndException() {
    }
    /**
     * Конструктор
     * @param message - принимает на вход строку
     */
    public ContainSequanceAtEndException(String message) {
        super(message);
    }
}
