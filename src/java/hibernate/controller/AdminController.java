/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.controller;

import hibernate.entity.*;
import hibernate.model.AdminModel;
import java.util.List;
import org.hibernate.annotations.Parameter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller

@RequestMapping(value = "admin")
public class AdminController {
    AdminModel adminModel = null;

    public AdminController() {
        adminModel = new AdminModel();
    }
    
    
    @RequestMapping(value = "initLogin")
    public ModelAndView initlogin(){
        ModelAndView model = new ModelAndView("admin-Login");
        return model;
    }
    
    @RequestMapping(value = "Login")
    public String Login(@ModelAttribute("User") Users user){

        List<Users> ls = adminModel.getUsers(user.getUserName());
        if(ls!=null && ls.size()>0)
           return "redirect:Home.htm";
        else
            return "admin-Login"; 
    }
    
    @RequestMapping(value = "Home")
    public ModelAndView initHome(){
        ModelAndView model = new ModelAndView("admin-Home");
        
        return model;
    }
}
