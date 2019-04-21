package com.cs.consumer.controller;

import com.cs.consumer.object.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User findById(@PathVariable Long id){
        if(this.restTemplate==null){
            System.out.printf("restTemplate");
            return null;
        }
        User user = this.restTemplate.getForObject("http://127.0.0.1:8000/" + id, User.class);
        return user;
    }

}