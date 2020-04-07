package com.gupao.client.web.controller;

import com.gupao.api.domain.Person;
import com.gupao.api.service.PersonService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;
import java.util.Random;

@RestController
public class PersonClientController {

    private static Random random = new Random();

    @Autowired
    private PersonService personService;

    @PostMapping("/p/save")
    public boolean save(@RequestBody Person person) {
        return personService.save(person);
    }

    @GetMapping("/p/find/all")
    public Collection<Person> findAll() {
        return personService.findAll();
    }

    public Collection<Person> errContent(){
        return Collections.emptyList();
    }
}
