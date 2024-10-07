package com.backend.springbootfirebase.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HealthController {

    @GetMapping( produces = "application/json")
    public String healthcheck() {

        return "Health Ok!";
    }

}