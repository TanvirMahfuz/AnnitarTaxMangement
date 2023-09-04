package com.example.demo.Package;

import com.example.demo.JavaClasses.Lawyer;
import com.example.demo.Service.LawyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LawyerController {
    @Autowired
    HomeController home;

    @Autowired
    LawyerService lawyerService;
    static int lawyer_Index=0;

    private int generateLawyerIndex(){
        int i=0,l=lawyerService.getAllLawyers().size();
        for ( i = 1; i < l; i++) {
            if(lawyerService.getLawyerById(i)==null){
                break;
            }
        }
        return i;
    }
    /*****Lawyer Section start*****/
    @RequestMapping("/NewLawyer")
    public String showLawyerForm(Model model) {
        home.database.lawyer_mode=false;
        model.addAttribute("lawyerInput", new Lawyer());
        return "NewLawyer";
    }

    @RequestMapping(value = "/submitLawyer",method = RequestMethod.POST)
    public ModelAndView submitLawyerForm(@ModelAttribute Lawyer lawyer) {

        home.mv.setViewName("LawyerHome.html");
        if(home.database.lawyer_mode==false)
        {
            lawyer_Index=generateLawyerIndex();
            lawyer.setLawyerID(lawyer_Index);
            home.current_user = lawyer.getLawyerID() - 1;
            lawyerService.createLawyer(lawyer);
            home.database.lawyer_mode = true;
            home.database.user_mode=false;
        }

        return home.mv;
    }
    @RequestMapping(value = "/ViewLawyerProfile",method = RequestMethod.GET)
    public ModelAndView lawyerProfileCon() {

        // Process the userInput object
        // (e.g., save it to a database, perform some logic)
        if(home.database.lawyer_mode) {
            home.mv.setViewName("ViewLawyerProfile.html");
            home.mv.addObject("lawyerTH", lawyerService.getLawyerById(home.current_user+1));
        }
        else
        {
            home.mv.setViewName("PreHome.html");
        }
        return home.mv;

    }

    @PostMapping("/deleteLawyer")
    public String deleteLawyer(){
        lawyerService.deleteLawyer(home.current_user+1);
        return "PreHome";
    }


    /*****lawyer Section end*****/

}
