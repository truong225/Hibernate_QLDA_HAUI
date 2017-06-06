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
import org.springframework.ui.ModelMap;
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
        ModelAndView model = new ModelAndView("redirect:/client/logout.htm");
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
    public ModelAndView initlecturerProjectProcess(@RequestParam(value = "id") int id, HttpSession session) {
        ModelAndView model = new ModelAndView("lecturer_Project_Process");
        List<Tiendo> lsTD = lecturersModel.getAllTDbyProjectId(id);
        Detai project = lecturersModel.getProjectByID(id);
        Users user = lecturersModel.getUserByID(project.getProjectStudentid());

        model.addObject("lsTD", lsTD);
        model.addObject("user", user);
        model.addObject("project", project);
        model.addObject("projectId", id);
        session.setAttribute("prid", id);
        session.setAttribute("prStudentId", user.getUserId());
        return model;
    }

    //init Them tien do
    @RequestMapping(value = "initLecturerProjectAdd")
    public ModelAndView initLecturerProcessAdd(@RequestParam(value = "projectId") int id) {

        ModelAndView model = new ModelAndView("lecturer_Project_add");
        Tiendo td = new Tiendo();
        Detai dt = lecturersModel.getProjectByID(id);
        td.setDetai(dt);
        model.addObject("projectId", td);

        return model;
    }

    //Xu ly them tien do
    @RequestMapping(value = "addProcess")
    public ModelAndView addProcess(@ModelAttribute("projectId") Tiendo td, HttpSession session) {

        int id = (int) session.getAttribute("prid");
        Detai dt = lecturersModel.getProjectByID(id);
        int studentId = (int) session.getAttribute("prStudentId");
        td.setUserId(studentId);
        td.setDetai(dt);
        boolean check = lecturersModel.addProcess(td);
        ModelAndView model = initLecturerProcessAdd(id);
        if (check) {
            model.getModelMap().put("alert", "Thêm thành công");
        } else {
            model.getModelMap().put("alert", "Thêm thất bại");
        }
        return model;
    }

    //Lay danh sach de tai cua minh
    @RequestMapping(value = "lecturer_ListProject")
    public ModelAndView lecturer_ListProject(HttpSession session) {
        int id = Integer.valueOf(session.getAttribute("id").toString());
        ModelAndView model = new ModelAndView("lecturer_ListProject");
        List<Detai> lsDT = lecturersModel.getListProject(id);
        model.addObject("lsDT", lsDT);
        if (lsDT != null) {
            List<Users> lsStudent = new ArrayList<>();
            for (int i = 0; i < lsDT.size(); i++) {
                Users u = new Users();
                u = lecturersModel.getUserByID(lsDT.get(i).getProjectStudentid());
                lsStudent.add(u);
            }
            model.addObject("lsStudent", lsStudent);
        }

        return model;
    }

    //giao dien them tien do
    @RequestMapping(value = "initlecturer_addProject")
    public ModelAndView initLecturer_addProject() {

        ModelAndView model = new ModelAndView("lecturer_addProject");
        Detai project = new Detai();
        model.addObject("project", project);

        return model;
    }

    //Xu ly them de tai
    @RequestMapping(value = "addProject")
    public ModelAndView addProject(@ModelAttribute("project") Detai project, HttpSession session) {
        ModelAndView model = new ModelAndView("lecturer_addProject2");
        model.addObject("newProject", project);
        return model;
    }

    //Xu ly them de tai ( commit )
    @RequestMapping(value = "commitProject")
    public ModelAndView commitProject(@RequestParam(value = "projectName") String projectName, @RequestParam(value = "projectDescription") String projectDescription, HttpSession session) {
        Detai project = new Detai();
        int id = (int) session.getAttribute("id");
        project.setProjectInstructorid(id);
        project.setProjectName(projectName);
        project.setProjectDescription(projectDescription);
        boolean check = lecturersModel.addProject(project);

        return lecturer_ListProject(session);
    }
}
