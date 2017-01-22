/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.courses.controllers;

import com.courses.dao.CourseDao;
import com.courses.entity.Courses;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author sylva
 */
@ManagedBean(name = "admin")
@RequestScoped
public class AdminManaged {
    
    @EJB
    private CourseDao courseDao;
    
    private List<Courses> courses;
    
    @PostConstruct
    public void init(){
        courses = courseDao.findAll();
    }

    public List<Courses> getCourses() {
        return courses;
    }
  
}
