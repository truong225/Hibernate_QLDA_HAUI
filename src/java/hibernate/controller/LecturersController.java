/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.controller;

import hibernate.model.ClientModel;
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
    
    
    //Khai bao giao dien giảng viên
    @RequestMapping("lecturers-homepage")
    public ModelAndView initLecturersHomepage(){
        ModelAndView model = new ModelAndView("lecturers-homepage");
        
        return model;
    }
    
    //Khai bao giao dien giảng viên
    @RequestMapping("initlecturer-project-list-approve")
    public ModelAndView initLecturerProjectListApprove(){
        ModelAndView model = new ModelAndView("lecturer-project-list-approve");
        
        return model;
    }
}
