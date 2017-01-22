/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.courses.controllers;

import com.courses.dao.CourseDao;
import com.courses.entity.Courses;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author sylva
 */
@ManagedBean(name = "course")
@RequestScoped
public class CourseManaged implements Serializable{
    
    private static final long serialVersionUID = 1L;
   
    @EJB
    private CourseDao courseDao;
    
    private String title;
    
    private String content;
    
    private String image;
    
    public String createCourse(){
        
        try {
            courseDao.createCourse(title, content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return "admin";
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
   
}
