package com.br.curso.controllers;

import com.br.curso.models.Greeting;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final AtomicLong counter = new AtomicLong();
    private final String template = "Olá, %s!";

    @GetMapping()
    public ResponseEntity<Greeting> get(@RequestParam(value = "name", defaultValue = "World") String name){
        var greeting = new Greeting(counter.incrementAndGet(), String.format(template, name));

        return ResponseEntity.ok().body(greeting);
    }

}
