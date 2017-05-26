/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "client")
public class ClientController {
    
    @RequestMapping(value = "initHomePage")
    public ModelAndView initHomePage(){
        ModelAndView model = new ModelAndView("client-index");
        
        return model;
    }
}
