package com.tms.exception;

public class WrongLoginException extends Exception {

    public WrongLoginException() {
    }

    /**
     * Конструктор
     *
     * @param str - принимает на вход строку
     */
    public WrongLoginException(String str) {
        super(str);
    }


}
