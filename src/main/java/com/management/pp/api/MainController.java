package com.management.pp.api;


import com.management.pp.model.User;
import com.management.pp.orm.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class MainController {

    @Autowired
    UserDAO userDAO;

    @GetMapping("/user")
    public String getUser(@PathParam("name") String name) {
        return userDAO.getUser(name);
    }

    @PostMapping("/user")
    public void addUser(@PathParam("name") String name) {
        userDAO.addUser(name);
    }

}
