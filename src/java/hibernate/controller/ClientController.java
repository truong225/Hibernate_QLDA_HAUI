/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.controller;

import hibernate.entity.Detai;
import hibernate.entity.Tiendo;
import hibernate.entity.Users;
import hibernate.model.ClientModel;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
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

    //Khai bao client-index.jsp
    @RequestMapping(value = "initHomePage")
    public ModelAndView initHomePage() {
        ModelAndView model = new ModelAndView("homepage-index");

        return model;
    }

    //Khai bao trang client-DSGVHD
    @RequestMapping(value = "initDSGVHD")
    public ModelAndView initDSGVHD() {
        ModelAndView model = new ModelAndView("homepage-DSGVHD");
        //Lay danh sach Khoa
        List ls = clientModel.getAllFaculty();
        model.addObject("listFaculty", ls);
        return model;
    }

    @RequestMapping(value = "loadDSGVHD")
    public ModelAndView loadDSGVHD(@RequestParam(value = "faculty") String faculty) {
        List<Users> ls = clientModel.getAllDSGVByID(faculty);
        ModelAndView map = new ModelAndView("homepage-DSGVHD_1");
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
        List<Users> ls = clientModel.getUsersSV(user);
        if (ls != null && ls.size() > 0) {
            Users users = ls.get(0);
            model = new ModelAndView("student-Homepage");
            model.addObject("user", users);
            session.setAttribute("Username", users.getUserFullname());
            session.setAttribute("avatar", users.getUserAvatar());
            session.setAttribute("id", users.getUserId());
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
                model = new ModelAndView("student-Homepage");

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
                model = new ModelAndView("student-Task");
                int id = Integer.valueOf(session.getAttribute("id").toString());
                List<Tiendo> dsTD = clientModel.getAllTD(id);
                model.addObject("lstd", dsTD);
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

    //Khai bao giao dien danh sach de tai
    @RequestMapping(value = "initHompageProjectList")
    public ModelAndView initHompageProjectList() {
        ModelAndView model = new ModelAndView("homepage-project-list");
        List ls = clientModel.getAllFaculty();
        model.addObject("listFaculty", ls);

        return model;
    }

    @RequestMapping(value = "loadHomepageDSDT")
    public ModelAndView loadHomepageDSDT(@RequestParam(value = "faculty") String faculty) {
        List<Users> ls = clientModel.getAllDSGVByID(faculty);
        ModelAndView model = new ModelAndView("homepage-project-list_1");
        // model.addObject("listGVHD", ls);
        List ls1 = clientModel.getAllFaculty();
        model.addObject("listFaculty", ls1);
        List<Detai> lsDT = clientModel.getAllDT(faculty);
        model.addObject("listDT", lsDT);
        List<Users> lsUser = clientModel.getAllGVByDSDT(lsDT);
        model.addObject("listUsers", lsUser);
        return model;
    }

    //Khai bao trang dang ki de tai
    @RequestMapping(value = "initStudent_regProjet")
    public ModelAndView initStudent_regProjet(HttpSession session) {
        ModelAndView model = new ModelAndView("student-RegProject_1");
        
       
        return model;
    }

    @RequestMapping(value = "initStudent_regProjet2")
    public ModelAndView initStudent_regProjet2(@RequestParam(value = "type") String type) {
        ModelAndView model;
        if (type.equals("1")) {
            model = new ModelAndView("student-RegProject_2");
            List ls1 = clientModel.getAllFaculty();
            model.addObject("listFaculty", ls1);
            
        } else {
            model = new ModelAndView("");
        }

        return model;
    }

    //Lay khoa
    @RequestMapping(value = "regProjet2")
    public ModelAndView getAllDTbyFaculty(@RequestParam(value = "faculty") String faculty) {
        ModelAndView model = new ModelAndView("student-RegProject_3");
        //Lay danh sach khoa
        List ls1 = clientModel.getAllFaculty();
        model.addObject("listFaculty", ls1);
        //Lay danh sach de tai theo khoa da chon
        List<Detai> lsDT = clientModel.getAllDT(faculty);
        model.addObject("lsDT", lsDT);
        //Danh sach giang vien theo de tai
        List<Users> listUsers = clientModel.getAllGVByDSDT(lsDT);
        model.addObject("listUsers", listUsers);
        //De tai se dang ki
        Detai dt = new Detai();
        model.addObject("dt", dt);
        return model;
    }

    //Xu ly su kien dang ki
    @RequestMapping(value = "registProject")
    public ModelAndView registProject(@RequestParam(value = "dt") int dtId, HttpSession session) {
        int userId = Integer.valueOf(session.getAttribute("id").toString());
        boolean check = clientModel.regisProject(dtId,userId);
        ModelAndView model;
        if (check == true) {
            model = new ModelAndView("student-RegProject_registed");
        } else {
            model = new ModelAndView("student-RegProject_2_1");
            model.addObject("error", "Đề tài đã được đăng kí!");
        }
        return model;
    }
}
