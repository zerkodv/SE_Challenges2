package com.example.accountmanagement.controller;

import com.example.accountmanagement.dao.PersonDatabase;
import com.example.accountmanagement.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class personController {

    @Autowired
    PersonDatabase personDatabase;


    @GetMapping("/person")
    public ResponseEntity<List<Person>> getId() {
        try {
            return new ResponseEntity<>(personDatabase.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable("id") long id) {
        try {
            //check if teacher exist in database
            Person personObj = getPersonRec(id);

            if (personObj != null) {
                return new ResponseEntity<>(personObj, HttpStatus.OK);
            }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/teacher/{id}")
    public ResponseEntity<Person> updateTeacher(@PathVariable("id") long id, @RequestBody Person person) {

        //check if teacher exist in database
        Person personObj = getPersonRec(id);

        if (personObj != null) {
            personObj.setName(person.getName());
            personObj.setAddress(person.getAddress());
            personObj.setPostcode(person.getPostcode());
            personObj.setAge(person.getAge());
            personObj.setJob(person.getJob());
            personObj.setEmail(person.getEmail());
            personObj.setPhoneno(person.getPhoneno());
            return new ResponseEntity<>(personDatabase.save(personObj), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }



    private Person getPersonRec(long id) {
        Optional<Person> personObj = personDatabase.findById(id);

        if (personObj.isPresent()) {
            return personObj.get();
        }
        return null;
    }

}
