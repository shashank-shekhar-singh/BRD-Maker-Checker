package com.ssnk.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MainExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public String genericException(Model model, Exception ex) {
        model.addAttribute("exception", ex.toString());
        return "error";
    }
}
