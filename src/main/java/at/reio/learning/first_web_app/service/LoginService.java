/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.reio.learning.first_web_app.service;

import org.springframework.stereotype.Service;

/**
 *
 * @author reio
 */
@Service
public class LoginService {
    
    public boolean validateUser(String userId, String passWord) {
        return "reio".equals(userId) && "topsecret".equals(passWord);
    }
    
}
