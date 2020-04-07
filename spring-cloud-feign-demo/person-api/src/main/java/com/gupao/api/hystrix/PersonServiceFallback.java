package com.gupao.api.hystrix;

import com.gupao.api.domain.Person;
import com.gupao.api.service.PersonService;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;

@Component
public class PersonServiceFallback  implements PersonService {
    @Override
    public boolean save(Person person) {
        return false;
    }

    @Override
    public Collection<Person> findAll() {
        return  Collections.emptyList();
    }
}
