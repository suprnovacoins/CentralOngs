package com.example.spring.errorHandler;

public class OngNotFoundException extends RuntimeException {
    public OngNotFoundException(Long id) {
        super("Could not find ong " + id);
    }
}
