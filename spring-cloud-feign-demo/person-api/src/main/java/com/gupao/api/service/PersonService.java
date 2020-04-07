package com.gupao.api.service;

import com.gupao.api.domain.Person;
import com.gupao.api.hystrix.PersonServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;

@FeignClient(value = "person-service",fallback = PersonServiceFallback.class) // 服务提供方应用的名称
public interface PersonService {


    @PostMapping("/person/save")
    boolean save(@RequestBody Person person);

    @GetMapping("/person/find/all")
    Collection<Person> findAll();
}
