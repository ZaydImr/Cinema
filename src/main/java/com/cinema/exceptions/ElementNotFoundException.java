package com.cinema.exceptions;

public class ElementNotFoundException extends RuntimeException {
    public ElementNotFoundException(String msg) {
        super(msg);
    }
}
