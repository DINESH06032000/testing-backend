package com.example.backend;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Cont {

    @Autowired
    private Serv service;

    @Autowired
    private Repo repo;

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

    // Get student by ID
   
    @GetMapping("/hello/{id}")
    public Optional<Set> getStudentById(@PathVariable Long id) {
        return repo.findById(id);
    }

    // Update student
    
    @PutMapping("/hello/{id}")
    public Set updateStudent(@PathVariable Long id, @RequestBody Set studentData) {
        return repo.findById(id)
                .map(student -> {
                    student.setName(studentData.getName());
                    student.setEmail(studentData.getEmail());
                    return repo.save(student);
                })
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }

}
