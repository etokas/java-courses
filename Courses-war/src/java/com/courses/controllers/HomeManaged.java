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
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author sylva
 */
@ManagedBean
@RequestScoped
public class HomeManaged {
    
    @EJB
    private CourseDao courseDao;
    
    private List<Courses> courses;

    public List<Courses> getCourses() {
        return courses;
    }

    public void setCourses(List<Courses> courses) {
        this.courses = courses;
    }
    
    @PostConstruct
    public void init(){
        this.courses = courseDao.findAll();
    }

}
