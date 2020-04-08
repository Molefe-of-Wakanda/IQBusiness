package com.iqbusiness.registration.controllers;

import com.iqbusiness.registration.model.Person;
import com.iqbusiness.registration.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@Controller
@RequestMapping("/persons")
public class PersonsRegistrationController {
    @Autowired
    private PersonRepository personRepository;

    @GetMapping
    @ResponseBody
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    @DeleteMapping("/{idNumber}")
    public ResponseEntity<Void> unregister(@PathVariable String idNumber) {

        Person person = personRepository.findByIdNumber(idNumber);
        personRepository.delete(person);

        return ok().build();
    }

    @ResponseBody
    @PostMapping("/register")
    public Person register(@Valid @RequestBody Person person) {
        return personRepository.saveAndFlush(person);
    }
}
