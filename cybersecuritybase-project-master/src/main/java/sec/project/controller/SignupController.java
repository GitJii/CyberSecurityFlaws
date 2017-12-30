package sec.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignupController {

    @Autowired
    private UserDetailsService userDetailsService;

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String loadForm() {

//        if(userDetailsService.loadUserByUsername("Admin").toString().equals("Admin")){
//            return "redirect:/accessDenied";
//        }
        return "done";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
//    public String submitForm(@RequestParam String name, @RequestParam String address) {
    public String submitForm(@RequestParam String content) {
        
        return "done";
    }
//    
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String loginForm(@RequestParam String username, @RequestParam String password){
//        
//        return "redirect:/items";
//    }

}
