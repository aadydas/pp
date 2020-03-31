package com.management.pp.orm;


import com.management.pp.model.User;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class UserDAO {

    private TinkerPopProvider userProvider;

    @Autowired
    public UserDAO(TinkerPopProvider userProvider){
        this.userProvider = userProvider;
    }

    public void addUser(String user){
        userProvider.getG().addV(user);
    }

    public String getUser(String name){
        return String.valueOf(userProvider.getG().getGraph().traversal().V().values().has("name", name));
    }

//    public List<User> getUsers(){
//        userProvider.getG().getGraph().traversal().V().values("name");
//    }
}
