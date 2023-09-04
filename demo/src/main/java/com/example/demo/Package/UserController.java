package com.example.demo.Package;

import com.example.demo.JavaClasses.Lawyer;
import com.example.demo.JavaClasses.User;
import com.example.demo.Service.LawyerService;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class UserController {
    @Autowired
    HomeController home;

    @Autowired
    UserService userService;
    @Autowired
    LawyerService lawyerService;
    static int user_index=0;
    private int generateUserIndex(){
        int i=0,l=lawyerService.getAllLawyers().size();
        for ( i = 1; i < l; i++) {
            if(userService.getUserById(i)==null){
                break;
            }
        }
        return i;
    }
    /*****User Section start*****/
    @RequestMapping("/NewUser")
    public String showUserForm(Model model) {
        home.database.user_mode=false;
        model.addAttribute("userInput", home.user);
        return "Registration";

    }

    @RequestMapping("/editUser")
    public String showUsereditForm(Model model) {
        home.database.user_mode=false;
        model.addAttribute("userInput", home.user);
        return "NewUser";

    }

    @RequestMapping(value = "/submitUser",method = RequestMethod.POST)
    public ModelAndView submitUserForm(@ModelAttribute User user) {

        if(!home.database.user_mode)
        {
            if(user.getLawyer()==null){
                user.setLawyer(new Lawyer().emptyLawyer());
            }
            user_index=generateUserIndex();
            user.setId(user_index);
            home.current_user = user.getId();
            //home.database.addUser(user);
            userService.createUser(user);
            home.database.user_mode = true;
            home.database.lawyer_mode=false;
            home.mv.setViewName("UserHome.html");
        }
        else {
            home.mv.setViewName("UserHome.html");
        }
        return home.mv;
    }
    @RequestMapping(value = "/ViewUserProfile",method = RequestMethod.GET)
    public ModelAndView userProfileCon() {

        // Process the userInput object
        // (e.g., save it to a database, perform some logic)
        System.out.println(home.database.user_mode);
        if(home.database.user_mode) {
            home.mv.setViewName("ViewUserProfile.html");
            home.mv.addObject("userTH", userService.getUserById(home.current_user));
        }
        else
        {
            home.mv.setViewName("PreHome.html");
        }
        return home.mv;

    }
    /*****User Section end*****/

    @PostMapping("/addLawyer")
    public String addLawyer(@RequestParam("lawyerID")int id,Model model){
        if(home.database.user_mode){
            userService.updateUser(home.current_user,id+1);
            model.addAttribute("userTH",userService.getUserById(home.current_user));
            return "UserHome";
        }
        else return "PreHome";
    }
    @PostMapping("/deleteUser")
    public String deleteLawyer(){
        userService.deleteuser(home.current_user);
        return "PreHome";
    }
}
