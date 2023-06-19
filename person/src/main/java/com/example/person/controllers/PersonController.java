package com.example.person.controllers;

import com.example.person.model.Person;
import com.example.person.repositories.PersonRepository;
import com.example.person.services.PersonServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private static Logger logger = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    Environment environment;

    @Autowired
    private PersonRepository personRepository;

    @GetMapping
    public ResponseEntity<List<Person>> findAll(){
        List<Person> list = personRepository.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> findById (@PathVariable Long id){
        logger.info("PORT = "+ environment.getProperty("local.server.port"));
        Person obj = personRepository.findById(id).get();
        return ResponseEntity.ok(obj);
    }

}
