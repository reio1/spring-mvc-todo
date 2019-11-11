/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.reio.learning.first_web_app.presentation;

import at.reio.learning.first_web_app.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author reio
 */

@Controller
@SessionAttributes("username")
public class LoginController {
    
    private final LoginService loginService;

    // @Autowired - automatic constructor injection
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }
    
    
    
    @GetMapping("/login")
    // @ResponseBody
    public String loginLoginPage() {
        return "loginpage";
    }
    
    @PostMapping("/login")
    // @ResponseBody
    public String loginWelcomePage(@RequestParam String username, 
                                   @RequestParam String password,
                                   Model model) {
        boolean isValidUser = loginService.validateUser(username, password);
        System.out.println("--- " + isValidUser);
        if(isValidUser) {
           model.addAttribute("username", username);
           model.addAttribute("password", password);
            return "welcomepage";
        } else {
            model.addAttribute("errorMessage", "Invalid credentials");
            return "loginpage";
        }
    }
    
}
