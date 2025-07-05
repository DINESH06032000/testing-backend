package com.example.backend;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Cont {

    @Autowired
    private Serv service;

   

    @RequestMapping("/a")
    public String requestMethodName() {
    return "hello";
    }

    @ResponseBody
    @RequestMapping("/data")
    public String summa() {
    return "lorem";
    }

    @ResponseBody
    @RequestMapping("/sql")
    @CrossOrigin
    public Iterable<Set> get() {
    return service.getAll();
    }

   

}
