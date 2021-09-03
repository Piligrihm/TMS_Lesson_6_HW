package com.tms.exception;

public class WrongPasswordException extends Exception {

    public WrongPasswordException() {
    }

    /**
     * Конструктор
     *
     * @param str - принимает на вход строку
     */
    public WrongPasswordException(String str) {

        super(str);
    }
}
