/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.courses.controllers;

import com.courses.dao.UserDao;
import com.courses.entity.User;
import com.courses.utils.Session;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author sylva
 */
@ManagedBean(name = "user")
@RequestScoped
public class UserManaged implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @EJB
    private UserDao userDao;
    
    private String firstname;
    
    private String lastname;
    
    private String password;
    
    private String email;
    
    private String username;
        
    private String invalidMessage;
    
    public String register(){
        
        try {
            if (!userDao.userExist(username)) {
                userDao.create(firstname, lastname, password, email, username); 
                Session.getSession().setAttribute("username", username);
                return "/security/profile.xhtml?faces-redirect=true";

            } else {
                invalidMessage = "Le nom d'utilisateur existe deja";
                return "register";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }       
        return null;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getInvalidMessage() {
        return invalidMessage;
    }

    public void setInvalidMessage(String invalidMessage) {
        this.invalidMessage = invalidMessage;
    }
    
}
