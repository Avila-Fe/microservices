package com.example.person;

import com.example.person.model.Person;
import com.example.person.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class PersonApplication implements CommandLineRunner {

    @Autowired
    PersonRepository personRepository;

    public static void main(String[] args) {
        SpringApplication.run(PersonApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Person p1 = new Person("Felipe", "Avila", "SAP - PARANÁ - BRAZIL", "Male");
        Person p2 = new Person("Leonardo", "Avila", "SAP - PARANÁ - BRAZIL", "Male");
        Person p3 = new Person("Arthur", "Avila", "SAP - PARANÁ - BRAZIL", "Male");

        personRepository.saveAll(Arrays.asList(p1, p2, p3));

    }
}
