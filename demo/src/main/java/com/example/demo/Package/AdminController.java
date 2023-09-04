package com.example.demo.Package;

import com.example.demo.JavaClasses.Admin;
import com.example.demo.JavaClasses.Home;
import com.example.demo.JavaClasses.Lawyer;
import com.example.demo.Service.AdminService;
import com.example.demo.Service.LawyerService;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {
    @Autowired //bean-home
    HomeController home;
    @Autowired
    UserService userService;
    @Autowired
    LawyerService lawyerService;
    @Autowired
    AdminService adminService;
    @Autowired
    Admin admin;
    @RequestMapping("/requestuser")
    public String userReq(){
        admin.addRequestedLawyer(lawyerService.getLawyerById(home.current_user));
        return "ViewLawyerProfile";
    }

    @RequestMapping("/seePendingLawyerRequests")
    public String seePenLRCon(Model model){
        model.addAttribute("reqLawyersTH",admin.getLawyerList());
        return "PendingLawyerList";
    }

    @RequestMapping("/requesLawyer")
    public String lawyerReq(){
        admin.addRequestedusers(userService.getUserById(home.current_user));
        return "ViewLawyerProfile";
    }

    @RequestMapping("/seePendingUserRequests")
    public String seePenURCon(Model model){
        model.addAttribute("reqUsersTH",admin.getUserList());
        return "PendingLawyerList";
    }


}
