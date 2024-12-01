package com.example.crudtest1.service;

import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;
import javax.faces.bean.ApplicationScoped;

@Stateless
public class HelloService {

    public String sayHello(String name) {
        return "Hello! " + name;
    }
}
