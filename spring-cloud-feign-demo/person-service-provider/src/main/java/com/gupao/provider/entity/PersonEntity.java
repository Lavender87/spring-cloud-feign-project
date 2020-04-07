package com.gupao.provider.entity;

import com.gupao.api.domain.Person;

import javax.persistence.*;

@Entity
@Table(name="persons")
public class PersonEntity{

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
