package com.example.demo.JavaClasses;

import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataBase {
    @Autowired
    UserService userService;
    List<User> userList = new ArrayList<>();

    public void addUser(User user){
        userList.add(user);
    }
    public List<User> getUserList(){
        return userList;
    }
    public boolean user_mode=false;

    List<Lawyer> ReqLawyerList= new ArrayList<>();

    public void addReqLawyer(Lawyer lawyer)
    {
        ReqLawyerList.add(lawyer);
    }
    public List<Lawyer> getLawyerList(){
        return ReqLawyerList;
    }

    public boolean lawyer_mode=false;

}
