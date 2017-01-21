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
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sylva
 */
@ManagedBean(name = "login")
@RequestScoped
public class SecurityManaged implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @EJB
    private UserDao userDao;
        
    private String username;
    
    private String password;
    
    private String errorMessage;
    
    
    public String submit(){
        
        if(userDao.checkUser(username, password) == false) {
            errorMessage = "Informations saisis incorrect";
        } else {
           
            errorMessage = " ";
            HttpSession session = Session.getSession();
            session.setAttribute("username", username);
            
            return "/admin/admin.xhtml?faces-redirect=true";
        }
        
        return "login";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    
}
