package com.example.spring.errorHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class OngNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(OngNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String ongNotFoundHandler(OngNotFoundException ex){
        return ex.getMessage();
    }
}
