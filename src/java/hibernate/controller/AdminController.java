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
import org.springframework.ui.ModelMap;
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
    public ModelAndView initlogin() {
        ModelAndView model = new ModelAndView("admin-Login");
        return model;
    }

    @RequestMapping(value = "Login")
    public String Login(@ModelAttribute("User") Users user) {

        List<Users> ls = adminModel.getUsers(user.getUserName(), user.getUserPassword());
        if (ls != null && ls.size() > 0) {
            return "redirect:Home.htm";
        } else {
            return "redirect:LoginF.htm";
        }
    }

    @RequestMapping(value = "LoginF")
    public ModelAndView LoginF() {
        ModelAndView model = new ModelAndView("admin-Login");
        model.addObject("error", "   Đăng nhập thất bại!");
        return model;
    }

    @RequestMapping(value = "Home")
    public ModelAndView initHome() {
        ModelAndView model = new ModelAndView("admin-Home");
        List<Users> ls = adminModel.getDSSV();
        model.addObject("lsSV", ls);
        return model;
    }

    @RequestMapping(value = "inittksv")
    public ModelAndView initTKSV() {
        ModelAndView model = new ModelAndView("admin-tksv");
        List<Users> ls = adminModel.getDSSV();
        model.addObject("lsSV", ls);
        return model;
    }

    @RequestMapping(value = "inittkgv")
    public ModelAndView initTKGV() {
        ModelAndView model = new ModelAndView("admin-tkgv");
        List<Users> ls = adminModel.getDSGV();
        model.addObject("lsSV", ls);
        return model;
    }

    @RequestMapping(value = "intkad")
    public ModelAndView initTKAD() {
        ModelAndView model = new ModelAndView("admin-tkad");
        List<Users> ls = adminModel.getDSAdmin();
        model.addObject("lsSV", ls);
        return model;
    }

    @RequestMapping(value = "initDSDTActive")
    public ModelAndView initDSDT() {
        ModelAndView model = new ModelAndView("admin-dsdtactive");
        List<Detai> ls = adminModel.getAllDTActive();
        model.addObject("lsDT", ls);
        return model;
    }

    @RequestMapping(value = "initDSDTNonActive")
    public ModelAndView initDSDTNonActive() {
        ModelAndView model = new ModelAndView("admin-dsdtnonactive");
        List<Detai> ls = adminModel.getAllDTNonActive();
        model.addObject("lsDT", ls);
        return model;
    }

}
