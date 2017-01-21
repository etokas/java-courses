/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.courses.controllers;

import com.courses.dao.UserDao;
import com.courses.entity.User;
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
        
    
    public String register(){
        
        try {
             userDao.create(firstname, lastname, password, lastname);
             
             List<User> users = userDao.getAll();
             System.out.println("com.courses.controllers.UserManaged.register()");
             System.out.println(users);
           
        } catch (Exception e) {
            e.printStackTrace();
        }
       
        return "/security/profile.xhtml?faces-redirect=true";
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
    
    
}
