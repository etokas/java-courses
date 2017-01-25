/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.courses.controllers;

import com.courses.dao.CourseDao;
import com.courses.entity.Courses;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author sylva
 */
@ManagedBean(name = "views")
@RequestScoped
public class ViewManaged extends AbstractManaged implements Serializable{
    
    @EJB
    private CourseDao courseDao;
    
    private Courses course;

    public Courses getCourse() {
        return course;
    }

    public void setCourse(Courses course) {
        this.course = course;
    }
    
    @PostConstruct
    public void init(){
        System.out.println("com.courses.controllers.ViewCourseManaged.init()");
        String id = getContext().getRequestParameterMap().get("id");
        try {
            course = courseDao.find(id);
            setCourse(course);
        } catch (Exception e) {
            if (course == null) {
            }
        }
    }
}
