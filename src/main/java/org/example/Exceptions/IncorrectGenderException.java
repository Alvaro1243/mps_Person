package org.example.Exceptions;

public class IncorrectGenderException extends RuntimeException {
    public IncorrectGenderException(String message) {
        super(message);
    }
}
