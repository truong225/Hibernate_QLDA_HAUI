/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.controller;

import hibernate.entity.Users;
import hibernate.model.ClientModel;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
    public ModelAndView initHomePage(){
        ModelAndView model = new ModelAndView("client-index");
        
        return model;
    }
    
    
    
    //Khai bao trang client-DSGVHD
    @RequestMapping(value = "initDSGVHD")
    public ModelAndView initDSGVHD(){
        ModelAndView model = new ModelAndView("client-DSGVHD");
        //Lay danh sach Khoa
        List ls = clientModel.getAllFaculty();
        model.addObject("listFaculty", ls);
        return model;
    }
    
    
    @RequestMapping(value = "loadDSGVHD")
    public ModelAndView loadDSGVHD(@RequestParam(value = "faculty") String faculty){
        List<Users> ls = clientModel.getAllDSGVByID(faculty);
        ModelAndView map = new ModelAndView("client-DSGVHD_1");
        map.addObject("listGVHD", ls);
        List ls1 = clientModel.getAllFaculty();
        map.addObject("listFaculty", ls1);
        return map;
    }
    
}
