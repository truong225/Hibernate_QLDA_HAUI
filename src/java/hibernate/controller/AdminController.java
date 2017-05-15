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
    
    
    //Load form login
    @RequestMapping(value = "initLogin")
    public ModelAndView initlogin() {
        ModelAndView model = new ModelAndView("admin-Login");
        Users users = new Users();
        model.getModel().put("User", users);
        return model;
    }

    //Xu ly su kien login
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

    //Load trang chu
    @RequestMapping(value = "Home")
    public ModelAndView initHome() {
        ModelAndView model = new ModelAndView("admin-Home");

        return model;
    }

    
    //Load form danh sach sinh vien
    @RequestMapping(value = "inittksv")
    public ModelAndView initTKSV() {
        ModelAndView model = new ModelAndView("admin-tksv");
        //load du lieu sinh vien
        List<Users> ls = adminModel.getDSSV();
        model.addObject("lsSV", ls);
        return model;
    }

    //Load form danh sach giang vien
    @RequestMapping(value = "inittkgv")
    public ModelAndView initTKGV() {
        ModelAndView model = new ModelAndView("admin-tkgv");
        //load du lieu giang vien
        List<Users> ls = adminModel.getDSGV();
        model.addObject("lsSV", ls);
        return model;
    }

    //Load form danh sach admin
    @RequestMapping(value = "intkad")
    public ModelAndView initTKAD() {
        ModelAndView model = new ModelAndView("admin-tkad");
        //Load du lieu admin
        List<Users> ls = adminModel.getDSAdmin();
        model.addObject("lsSV", ls);
        return model;
    }

    //Load form danh sach de tai dang thuc hien
    @RequestMapping(value = "initDSDTActive")
    public ModelAndView initDSDT() {
        ModelAndView model = new ModelAndView("admin-dsdtactive");
        List<Detai> ls = adminModel.getAllDTActive();
        model.addObject("lsDT", ls);
        return model;
    }

    //Load form danh sach de tai da thuc hien
    @RequestMapping(value = "initDSDTNonActive")
    public ModelAndView initDSDTNonActive() {
        ModelAndView model = new ModelAndView("admin-dsdtnonactive");
        List<Detai> ls = adminModel.getAllDTNonActive();
        model.addObject("lsDT", ls);
        return model;
    }

    //Load form danh sach Giang vien huong dan
    @RequestMapping(value = "initDSGVHD")
    public ModelAndView initDSGVHD() {
        ModelAndView model = new ModelAndView("admin-dsgvhd");
        List<Users> ls = adminModel.getDSGVHD();
        model.addObject("lsSV", ls);
        return model;
    }

    //Load form danh sach Giang vien phan bien
    @RequestMapping(value = "initDSGVPB")
    public ModelAndView initDSGVPB() {
        ModelAndView model = new ModelAndView("admin-dsgvpb");
        List<Users> ls = adminModel.getDSGVPB();
        model.addObject("lsSV", ls);
        return model;
    }

    //Load form danh sach Hoi dong cham
    @RequestMapping(value = "initDSHDC")
    public ModelAndView initDSHDC() {
        ModelAndView model = new ModelAndView("admin-dshdc");
        List<Users> ls = adminModel.getDSHDC();
        model.addObject("lsSV", ls);
        return model;
    }

    //Xu ly xoa user
    @RequestMapping(value = "delete.htm")
    public String delete(@RequestParam(value = "userId") Integer userId, @RequestParam(value = "model") String model) {
        boolean check = adminModel.Delete(userId);
        if (check == true) {
            return "redirect:" + model;
        } else {
            return "";
        }
    }

    //Load form them Sinh Vien
    @RequestMapping(value = "initFormAdaSV")
    public ModelAndView initFormAddSV() {
        ModelAndView model = new ModelAndView("admin-formadsv");
        Users sv = new Users();
        model.getModelMap().put("sv", sv);
        return model;
    }

    //Load form them admin
    @RequestMapping(value = "initFormAdaAD")
    public ModelAndView initFormAddAD() {
        ModelAndView model = new ModelAndView("admin-formadad");
        Users sv = new Users();
        model.getModelMap().put("sv", sv);
        return model;
    }

    //Load form them Giang vien
    @RequestMapping(value = "initFormAdaGV")
    public ModelAndView initFormAddGV() {
        ModelAndView model = new ModelAndView("admin-formadgv");
        Users sv = new Users();
        model.getModelMap().put("sv", sv);
        return model;
    }

    //Xu ly them sinh vien
    @RequestMapping(value = "insertDSSV")
    public String insertSV(@ModelAttribute(value = "sv") Users sv) {
        boolean check = adminModel.InsertSV(sv);
        if (check == true) {
            return "redirect:inittksv.htm";
        }
        return "";
    }
    
    //Xu ly them giang vien
    @RequestMapping(value = "insertDSGV")
    public String insertGV(@ModelAttribute(value = "sv") Users sv) {
        boolean check = adminModel.InsertSV(sv);
        if (check == true) {
            return "redirect:inittkgv.htm";
        }
        return "";
    }
    
    //Xu ly them admin
    @RequestMapping(value = "insertDSAD")
    public String insertAD(@ModelAttribute(value = "sv") Users sv) {
        boolean check = adminModel.InsertSV(sv);
        if (check == true) {
            return "redirect:intkad.htm";
        }
        return "";
    }

    //Load form them De tai
    @RequestMapping(value = "initFormAddDT")
    public ModelAndView initFormAdDT() {
        ModelAndView model = new ModelAndView("admin-formadddt");
        Detai dt = new Detai();
        model.getModelMap().put("dt", dt);
        return model;
    }

    //Xu ly them De tai
    @RequestMapping(value = "insertDSDT")
    public String insertDT(@ModelAttribute(value = "dt") Detai dt) {
        boolean check = adminModel.InsertDT(dt);
        if (check == true) {
            return "redirect:initDSDTActive.htm";
        }

        return "";
    }

    //Load form update
    @RequestMapping(value = "initUpdateUser")
    public ModelAndView initFormUpdateUsers(@RequestParam("userId") Integer userId) {
        ModelAndView model = new ModelAndView("admin-formupdatesv");
        List<Users> ls = adminModel.getUsers(userId);
        Users users = ls.get(0);
        model.getModelMap().put("sv", users);
        return model;
    }

    //Xu ly update SinhVien
    @RequestMapping(value = "updateUser")
    public String updateUsers(@ModelAttribute(value = "sv") Users users) {
        boolean check = adminModel.Update(users);
        if (check == true) {
            return "redirect:inittksv.htm";
        } else {
            return "";
        }
    }
    
    //Xu ly update admin
    @RequestMapping(value = "updateUserAD")
    public String updateUsersAD(@ModelAttribute(value = "sv") Users users) {
        boolean check = adminModel.Update(users);
        if (check == true) {
            return "redirect:intkad.htm";
        } else {
            return "";
        }
    }
    
    //Xu ly upadte Giang vien
    @RequestMapping(value = "updateUserGV")
    public String updateUsersGV(@ModelAttribute(value = "sv") Users users) {
        boolean check = adminModel.Update(users);
        if (check == true) {
            return "redirect:inittkgv.htm";
        } else {
            return "";
        }
    }
    
    //Load form update admin
    @RequestMapping(value = "initUpdateUserAD")
    public ModelAndView initFormUpdateUsersAD(@RequestParam("userId") Integer userId) {
        ModelAndView model = new ModelAndView("admin-formupdatead");
        List<Users> ls = adminModel.getUsers(userId);
        Users users = ls.get(0);
        model.getModelMap().put("sv", users);
        return model;
    }
    
    
    //Load form update Giang vien
    @RequestMapping(value = "initUpdateUserGV")
    public ModelAndView initFormUpdateUsersGV(@RequestParam("userId") Integer userId) {
        ModelAndView model = new ModelAndView("admin-formupdategv");
        List<Users> ls = adminModel.getUsers(userId);
        Users users = ls.get(0);
        model.getModelMap().put("sv", users);
        return model;
    }
    
    //Load form update de tai
    @RequestMapping(value = "initUpdateDSDT")
    public ModelAndView initUpdateDT(@RequestParam("projectId") Integer projectId) {
        ModelAndView model = new ModelAndView("admin-formupdateDT");
        Detai dt = adminModel.getDetai(projectId);
        model.getModelMap().put("dt", dt);
        return model;
    }
    
    @RequestMapping(value = "updateDT")
    public String updateDT(@ModelAttribute("dt") Detai dt){
        boolean check = adminModel.UpdateDT(dt);
        if(check ==true)
            return "redirect:initDSDTActive.htm";
        else
            return "";
    }
    
    @RequestMapping(value = "deleteDT")
    public String deleteDT(@RequestParam(value = "projectId") Integer projectId){
        boolean check = adminModel.DeleteDT(projectId);
        if(check ==true)
            return "redirect:initDSDTActive.htm";
        else
            return "";
    }
    
    @RequestMapping(value = "intknotactive")
    public ModelAndView initDSNotActive(){
        ModelAndView model = new ModelAndView("admin-tknotactive");
        List<Users> ls = adminModel.getDSNonActive();
        model.addObject("lsSV", ls);
        return model;
    }
}
