package com.management.pp.api;

import com.management.pp.model.Person;
import com.management.pp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping(value = "/person")
public class BaseController {

    @Autowired
    PersonService personService;

//    @PostMapping("/create")
//    void createBaseGraph(){
//        personService.postPerson();
//    }

    @PostMapping()
    void addUser(@RequestBody Person person){
        personService.addPerson(person);
    }

    @GetMapping()
    String getUserAgeByName(@PathParam("name") String name){
        return personService.findByName(name).property("name").value().toString();
    }

}