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
        Users users = new Users();
        model.getModel().put("User", users);
        return model;
    }

    @RequestMapping(value = "Login")
    public ModelAndView Login(@ModelAttribute("User") Users user) {
        ModelAndView model;
        List<Users> ls = adminModel.getUsersAd(user);
        if (ls != null && ls.size() > 0) {
            Users users = ls.get(0);
            model = new ModelAndView("admin-Home");
            model.addObject("user", user);
            String name = users.getUserFullname();
            model.getModel().put("accountName", name);
            return model;
        } else {
            model = new ModelAndView("admin-Login");
            Users users = new Users();
            model.getModel().put("User", users);
            model.addObject("error", "   Đăng nhập thất bại!");
            return model;
        }
    }

    @RequestMapping(value = "LoginF")
    public ModelAndView LoginF() {
        ModelAndView model = new ModelAndView("admin-Login");
        Users users = new Users();
        model.getModel().put("User", users);
        model.addObject("error", "   Đăng nhập thất bại!");
        return model;
    }

    @RequestMapping(value = "Home")
    public ModelAndView initHome() {
        ModelAndView model = new ModelAndView("admin-Home");

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

    @RequestMapping(value = "initDSGVHD")
    public ModelAndView initDSGVHD() {
        ModelAndView model = new ModelAndView("admin-dsgvhd");
        List<Users> ls = adminModel.getDSGVHD();
        model.addObject("lsSV", ls);
        return model;
    }

    @RequestMapping(value = "initDSGVPB")
    public ModelAndView initDSGVPB() {
        ModelAndView model = new ModelAndView("admin-dsgvpb");
        List<Users> ls = adminModel.getDSGVPB();
        model.addObject("lsSV", ls);
        return model;
    }

    @RequestMapping(value = "initDSHDC")
    public ModelAndView initDSHDC() {
        ModelAndView model = new ModelAndView("admin-dshdc");
        List<Users> ls = adminModel.getDSHDC();
        model.addObject("lsSV", ls);
        return model;
    }

    @RequestMapping(value = "delete.htm")
    public String delete(@RequestParam(value = "userId") Integer userId, @RequestParam(value = "model") String model) {
        boolean check = adminModel.Delete(userId);
        if (check == true) {
            return "redirect:" + model;
        } else {
            return "";
        }
    }

    @RequestMapping(value = "initFormAdaSV")
    public ModelAndView initFormAddSV() {
        ModelAndView model = new ModelAndView("admin-formadsv");
        Users sv = new Users();
        model.getModelMap().put("sv", sv);
        return model;
    }

    @RequestMapping(value = "initFormAdaAD")
    public ModelAndView initFormAddAD() {
        ModelAndView model = new ModelAndView("admin-formadad");
        Users sv = new Users();
        model.getModelMap().put("sv", sv);
        return model;
    }

    @RequestMapping(value = "initFormAdaGV")
    public ModelAndView initFormAddGV() {
        ModelAndView model = new ModelAndView("admin-formadgv");
        Users sv = new Users();
        model.getModelMap().put("sv", sv);
        return model;
    }

    @RequestMapping(value = "insertDSSV")
    public String insertSV(@ModelAttribute(value = "sv") Users sv) {
        boolean check = adminModel.InsertSV(sv);
        if (check == true) {
            return "redirect:inittksv.htm";
        }
        return "";
    }

    @RequestMapping(value = "initFormAddDT")
    public ModelAndView initFormAdđT() {
        ModelAndView model = new ModelAndView("admin-formadddt");
        Detai dt = new Detai();
        model.getModelMap().put("dt", dt);
        return model;
    }

    @RequestMapping(value = "insertDSDT")
    public String insertDT(@ModelAttribute(value = "dt") Detai dt) {
        boolean check = adminModel.InsertDT(dt);
        if (check == true) {
            return "redirect:initDSDTActive.htm";
        }

        return "";
    }

    @RequestMapping(value = "initUpdateUser")
    public ModelAndView initFormUpdateUsers(@RequestParam("userId") Integer userId) {
        ModelAndView model = new ModelAndView("admin-formupdatesv");
        List<Users> ls = adminModel.getUsers(userId);
        Users users = ls.get(0);
        model.getModelMap().put("sv", users);
        return model;
    }

    @RequestMapping(value = "updateUser")
    public String updateUsers(@ModelAttribute(value = "sv") Users users) {
        boolean check = adminModel.Update(users);
        if (check == true) {
            return "redirect:inittksv.htm";
        } else {
            return "";
        }
    }
    
    @RequestMapping(value = "updateUserAD")
    public String updateUsersAD(@ModelAttribute(value = "sv") Users users) {
        boolean check = adminModel.Update(users);
        if (check == true) {
            return "redirect:intkad.htm";
        } else {
            return "";
        }
    }
    
    @RequestMapping(value = "updateUserGV")
    public String updateUsersGV(@ModelAttribute(value = "sv") Users users) {
        boolean check = adminModel.Update(users);
        if (check == true) {
            return "redirect:inittkgv.htm";
        } else {
            return "";
        }
    }
    
    @RequestMapping(value = "initUpdateUserAD")
    public ModelAndView initFormUpdateUsersAD(@RequestParam("userId") Integer userId) {
        ModelAndView model = new ModelAndView("admin-formupdatead");
        List<Users> ls = adminModel.getUsers(userId);
        Users users = ls.get(0);
        model.getModelMap().put("sv", users);
        return model;
    }
    
    @RequestMapping(value = "initUpdateUserGV")
    public ModelAndView initFormUpdateUsersGV(@RequestParam("userId") Integer userId) {
        ModelAndView model = new ModelAndView("admin-formupdategv");
        List<Users> ls = adminModel.getUsers(userId);
        Users users = ls.get(0);
        model.getModelMap().put("sv", users);
        return model;
    }
}
