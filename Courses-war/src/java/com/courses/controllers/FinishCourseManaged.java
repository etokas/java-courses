/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.courses.controllers;

import static com.courses.controllers.AbstractManaged.getContext;
import com.courses.dao.CourseDao;
import com.courses.entity.Courses;
import com.courses.entity.Quizz;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author sylva
 */
@ManagedBean(name = "finish")
@RequestScoped
public class FinishCourseManaged extends AbstractManaged{
    
     @EJB
    private CourseDao courseDao;
    
    private Courses course;
    
    private Quizz quizz;

    public Courses getCourse() {
        return course;
    }

    public void setCourse(Courses course) {
        this.course = course;
    }
    
    @PostConstruct
    public void init(){
        String id = getContext().getRequestParameterMap().get("id");
        try {
            course = courseDao.find(id);
            setCourse(course);
        } catch (Exception e) {
            if (course == null) {
            }
        }
    }

    public Quizz getQuizz() {
        return quizz;
    }

    public void setQuizz(Quizz quizz) {
        this.quizz = quizz;
    }
    
    
}
