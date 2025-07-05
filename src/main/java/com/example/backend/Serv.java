package com.example.backend;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Serv {


    @Autowired
    private Repo repo;

    public Iterable<Set> getAll(){
        return repo.findAll();
    }

    

   
    

    


     
}
