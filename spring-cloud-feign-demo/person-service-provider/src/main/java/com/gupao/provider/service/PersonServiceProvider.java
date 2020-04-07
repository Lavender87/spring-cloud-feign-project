package com.gupao.provider.service;

import com.gupao.api.domain.Person;
import com.gupao.provider.entity.PersonEntity;
import com.gupao.provider.repository.PersonsRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @since 2017/11/5
 */
@RestController
public class PersonServiceProvider {

    private final Map<Long, Person> persons = new ConcurrentHashMap<>();


    private static Random random = new Random();

    @Autowired
    private PersonEntityService personEntityService;
    @Autowired
    private PersonsRepository personsRepository;
    /**
     * 保存
     *
     * @param person {@link Person}
     * @return 如果成功，<code>true</code>
     */
    @PostMapping(value = "/person/save")
    public boolean savePerson(@RequestBody Person person) {
//        return persons.put(person.getId(), person) == null;
        PersonEntity person1 = new PersonEntity();
        BeanUtils.copyProperties(person, person1);
//        personEntityService.savePerson(person1);
        personsRepository.save(person1);
        return true;
    }


    @GetMapping(value = "/person/list")
    public Page<PersonEntity> list(Pageable pageable) {
         return  personsRepository.findAll(pageable);
    }
    /**
     * 查找所有的服务
     *
     * @return
     */
    @GetMapping(value = "/person/find/all")
    @HystrixCommand(fallbackMethod = "errContent",
            commandProperties={
                    @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds" ,value = "200")
            })
    public Collection<Person> findAllPersons() throws InterruptedException {
        int value = random.nextInt(200);
        System.out.println("helloWorld() costs " + value + " ms.");
        Thread.sleep(value);
        return persons.values();
    }


    public Collection<Person> errContent(){
        System.err.println("hello ,turn to errContent");
        return Collections.emptyList();
    }


}
