package com.example.demo.Package;

import com.example.demo.JavaClasses.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired //bean-home
    Home home;
    @Autowired
    User user;
    @Autowired
    DataBase database;
    @Autowired
    Lawyer lawyer;

    ModelAndView mv = new ModelAndView();
     static int current_user=0;

    public static int getCurrent_user() {
        return current_user;
    }


    @RequestMapping("/PreHome")
    public ModelAndView HomeCon(){
        database.user_mode=false;
        mv.setViewName("PreHome.html");
        return mv;
    }
    @RequestMapping("/")
    public ModelAndView HomeCon1(){
        ModelAndView mv = new ModelAndView("homepage");
        return mv;
    }
    @RequestMapping("/Home")
    public String Home(){
        if(database.lawyer_mode)
            return "LawyerHome";
        else if(database.user_mode)
            return "UserHome";
        else return "PreHome";

    }
}
