/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.controller;

import hibernate.entity.*;
import hibernate.model.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author we
 */
@Controller
@RequestMapping(value = "lecture")
public class LecturersController {

    Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    LecturersModel lecturersModel;

    public LecturersController() {
        lecturersModel = new LecturersModel();
    }

    //Khai bao giao dien giảng viên
    @RequestMapping("lecturers-homepage")
    public ModelAndView initLecturersHomepage() {
        ModelAndView model = new ModelAndView("lecturers-homepage");

        return model;
    }

    //Su kien dang xuat
    @RequestMapping(value = "logout")
    public ModelAndView Logout(HttpSession session) {
        ModelAndView model = new ModelAndView("redirect:/client/client-login");
        session.setAttribute("Username", "");
        session.removeAttribute("avatar");
        session.removeAttribute("Username");
        Users users = new Users();
        model.getModel().put("User", users);
        return model;
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
    public ModelAndView initloginError(HttpSession session) {

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
        ClientModel clientModel = new ClientModel();
        List<Users> ls = clientModel.getUsersSV(user);
        if (ls != null && ls.size() > 0) {
            Users users = ls.get(0);
            if (users.getUserType() == 1) {
                model = new ModelAndView("student-Homepage");
            } else if (users.getUserType() == 2) {
                model = new ModelAndView("redirect:/lecture/lecturers-homepage.htm");
            } else {
                model = new ModelAndView("student-Homepage");
            }
            model.addObject("user", users);
            session.setAttribute("Username", users.getUserFullname());
            session.setAttribute("avatar", users.getUserAvatar());
            session.setAttribute("id", users.getUserId());
            session.setAttribute("pw", users.getUserPassword());
            return model;
        } else {
            model = new ModelAndView("client-login");
            Users users = new Users();
            model.getModel().put("User", users);
            model.addObject("error", "   Sai tài khoản hoặc mật khẩu!");
            return model;
        }
    }

    //Khai bao giao dien giảng viên
    @RequestMapping("initlecturer-project-list-approve")
    public ModelAndView initLecturerProjectListApprove() {
        ModelAndView model = new ModelAndView("lecturer-project-list-approve");

        return model;
    }

    //Giao dien phe duyet de tai
    @RequestMapping(value = "lecturerProjectListApprove")
    public ModelAndView lecturerProjectListApprove(HttpSession session) {
        ModelAndView model = new ModelAndView("lecturer-project-list-approve");
        int id = Integer.valueOf(session.getAttribute("id").toString());
        List<Message> lsMes = lecturersModel.getAllMessageApprove(id);
        List<Users> lsUsers = new ArrayList<>();
        List<Detai> lsProject = new ArrayList<>();

        for (Message i : lsMes) {
            Users u = lecturersModel.getUserByID(i.getMessageStudentId());
            Detai d = lecturersModel.getProjectByID(i.getMessageProjectId());
            lsUsers.add(u);
            lsProject.add(d);
        }
        model.addObject("lsMes", lsMes);
        model.addObject("lsUsers", lsUsers);
        model.addObject("lsProject", lsProject);
        return model;
    }

    //Phe duyet de tai
    @RequestMapping(value = "approveProject")
    public ModelAndView approveProject(HttpSession session, @RequestParam(value = "mesId") int mesId) {
        Message mes = lecturersModel.getMesByID(mesId);
        mes.setMessageStatus(1);
        boolean check = lecturersModel.updateMessage(mes);
        if (check) {
            Detai project = lecturersModel.getProjectByID(mes.getMessageProjectId());
            project.setProjectProgress(1);
            Date startDate = new Date();
            project.setProjectStartdate(sdf.format(startDate));
            check = lecturersModel.updateProject(project);
        }
        return lecturerProjectListApprove(session);
    }

    //Lay danh sach sinh vien dang huong dan
    @RequestMapping(value = "initlecturer_Project_List_Ongoing")
    public ModelAndView initlecturer_Project_List_Ongoing(HttpSession session) {
        int id = Integer.valueOf(session.getAttribute("id").toString());
        ModelAndView model = new ModelAndView("lecturer_Project_List_Ongoing");
        List<Detai> lsDT = lecturersModel.getListProjectOngoing(id);
        model.addObject("lsDT", lsDT);
        if (lsDT != null) {
            List<Users> lsStudent = new ArrayList<>();
            for (int i = 0; i < lsDT.size(); i++) {
                Users u = lecturersModel.getUserByID(lsDT.get(i).getProjectStudentid());
                lsStudent.add(u);
            }
            model.addObject("lsStudent", lsStudent);
        }

        return model;
    }

    
    //init Theo doi tien do
    @RequestMapping(value = "initlecturerProjectProcess")
    public ModelAndView initlecturerProjectProcess(@RequestParam(value = "id") int id){
        ModelAndView model = new ModelAndView("lecturer_Project_Process");
        List<Tiendo> lsTD = lecturersModel.getAllTDbyProjectId(id);
        Users user = new Users();
        if(lsTD.size()>0){
            int userId = lsTD.get(0).getUserId();
            user = lecturersModel.getUserByID(userId);
        }
        model.addObject("lsTD", lsTD);
        model.addObject("user", user);
        
        return model;
    }
}
