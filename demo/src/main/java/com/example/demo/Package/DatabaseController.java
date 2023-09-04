package com.example.demo.Package;

import com.example.demo.JavaClasses.Lawyer;
import com.example.demo.Service.LawyerService;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DatabaseController {
    @Autowired
    HomeController home;
    @Autowired
    UserService userService;
    @Autowired
    LawyerService lawyerService;
    @RequestMapping("/seeLawyerList")

    public String getLawyerList(Model model){
        model.addAttribute("lawyerlistTH",lawyerService.getAllLawyers());
        return "LawyerList";
    }
    @PostMapping("/DemoLawyerProfile")
    public String processExtraAction(@RequestParam("id") int id, Model model ) {
        model.addAttribute("lawyerTH",lawyerService.getLawyerById(id));
        return "DemoLawyerProfile";
    }


}
