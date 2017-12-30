/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sec.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignInController {

    @Autowired
    private UserDetailsService userDetailsService;

    @RequestMapping("*")
    public String defaultMapping() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loadForm() {
        return "redirect:/items";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String submitForm(@RequestParam String name, @RequestParam String password) {
        userDetailsService.loadUserByUsername(name);
        return "redirect:/items";
    }
//    
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String loginForm(@RequestParam String username, @RequestParam String password){
//        
//        return "redirect:/items";
//    }

}

