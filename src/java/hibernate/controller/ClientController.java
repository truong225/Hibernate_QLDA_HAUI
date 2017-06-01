/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.controller;

import hibernate.entity.Users;
import hibernate.model.ClientModel;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "client")
public class ClientController {

    ClientModel clientModel;

    public ClientController() {
        clientModel = new ClientModel();
    }

    //Khai bao client-index.jsp
    @RequestMapping(value = "initHomePage")
    public ModelAndView initHomePage() {
        ModelAndView model = new ModelAndView("client-index");

        return model;
    }

    //Khai bao trang client-DSGVHD
    @RequestMapping(value = "initDSGVHD")
    public ModelAndView initDSGVHD() {
        ModelAndView model = new ModelAndView("client-DSGVHD");
        //Lay danh sach Khoa
        List ls = clientModel.getAllFaculty();
        model.addObject("listFaculty", ls);
        return model;
    }

    @RequestMapping(value = "loadDSGVHD")
    public ModelAndView loadDSGVHD(@RequestParam(value = "faculty") String faculty) {
        List<Users> ls = clientModel.getAllDSGVByID(faculty);
        ModelAndView map = new ModelAndView("client-DSGVHD_1");
        map.addObject("listGVHD", ls);
        List ls1 = clientModel.getAllFaculty();
        map.addObject("listFaculty", ls1);
        return map;
    }

    //Khai bao trang dang nhap nguoi dung
    @RequestMapping(value = "initLogin")
    public ModelAndView initlogin() {
        ModelAndView model = new ModelAndView("client-login");
        Users users = new Users();
        model.getModel().put("User", users);
        return model;
    }

    //Khai bao trang dang nhap neu nguoi dung chua dang nhap
    @RequestMapping(value = "initLogin-error")
    public ModelAndView initloginError() {
        ModelAndView model = new ModelAndView("client-login");
        Users users = new Users();
        model.getModel().put("User", users);
        model.addObject("error", "   Vui lòng đăng nhập trước khi truy cập vào hệ thống!");
        return model;
    }

    //Xu ly su kien dang nhap
    @RequestMapping(value = "Login")
    public ModelAndView Login(HttpSession session, @ModelAttribute("User") Users user) {
        ModelAndView model;
        List<Users> ls = clientModel.getUsers(user);
        if (ls != null && ls.size() > 0) {
            Users users = ls.get(0);
            model = new ModelAndView("client-Homepage");
            model.addObject("user", users);
            session.setAttribute("Username", users.getUserFullname());
            session.setAttribute("avatar", users.getUserAvatar());
            return model;
        } else {
            model = new ModelAndView("client-login");
            Users users = new Users();
            model.getModel().put("User", users);
            model.addObject("error", "   Sai tài khoản hoặc mật khẩu!");
            return model;
        }
    }

    //Mo trang client-Homepage
    @RequestMapping(value = "initClientHompage")
    public ModelAndView initClientHomepage(HttpSession session) {
        ModelAndView model = new ModelAndView("client-404");
        try {
            if (CheckLogin(session)) {
                model = new ModelAndView("client-Homepage");

                return model;
            } else {
                model = new ModelAndView("client-login");
                Users users = new Users();
                model.getModel().put("User", users);
                model.addObject("error", "   Vui lòng đăng nhập trước khi truy cập vào hệ thống!");
                return model;
            }
        } catch (Exception e) {
            model = new ModelAndView("client-login");
            Users users = new Users();
            model.getModel().put("User", users);
            model.addObject("error", "   Vui lòng đăng nhập trước khi truy cập vào hệ thống!");
            return model;
        }

    }
    
    //Khai bao trang quan ly de tai
    @RequestMapping(value = "initClient-Task")
    public ModelAndView initClientTask(HttpSession session) {
        ModelAndView model = new ModelAndView("client-404");
        try {
            if (CheckLogin(session)) {
                model = new ModelAndView("client-Task");

                return model;
            } else {
                model = new ModelAndView("client-login");
                Users users = new Users();
                model.getModel().put("User", users);
                model.addObject("error", "   Vui lòng đăng nhập trước khi truy cập vào hệ thống!");
                return model;
            }
        } catch (Exception e) {
            model = new ModelAndView("client-login");
            Users users = new Users();
            model.getModel().put("User", users);
            model.addObject("error", "   Vui lòng đăng nhập trước khi truy cập vào hệ thống!");
            return model;
        }

    }

    //Su kien dang xuat
    @RequestMapping(value = "logout")
    public ModelAndView Logout(HttpSession session) {
        ModelAndView model = new ModelAndView("client-login");
        session.setAttribute("Username", "");
        session.removeAttribute("avatar");
        session.removeAttribute("Username");
        Users users = new Users();
        model.getModel().put("User", users);
        return model;
    }
    
    

    //Check Login
    public boolean CheckLogin(HttpSession session) {
        if (!session.getAttribute("Username").equals("") || session == null) {
            return true;
        } else {
            return false;
        }
    }
}
