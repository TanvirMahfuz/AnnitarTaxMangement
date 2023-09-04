package com.example.demo.JavaClasses;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Entity
@Component
public class Admin {
    @Id
    private int adminID;
    private String AdminName;
    private String Password;

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public String getAdminName() {

        return AdminName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setAdminName(String adminName) {
        AdminName = adminName;
    }

    @OneToOne
    User user;
    @OneToOne
    Lawyer lawyer;

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    List<Lawyer> lawyerList;
    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    List<User> userList;

    public void addRequestedLawyer(Lawyer lawyer){
        lawyerList.add(lawyer);
    }
    public void addRequestedusers(User user){
        userList.add(user);
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Lawyer getLawyer() {
        return lawyer;
    }

    public void setLawyer(Lawyer lawyer) {
        this.lawyer = lawyer;
    }

    public List<Lawyer> getLawyerList() {
        return lawyerList;
    }

    public void setLawyerList(List<Lawyer> lawyerList) {
        this.lawyerList = lawyerList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
