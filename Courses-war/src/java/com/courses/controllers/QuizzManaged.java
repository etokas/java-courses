/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.courses.controllers;

import com.courses.dao.CourseDao;
import com.courses.dao.QuizzDao;
import com.courses.entity.Courses;
import com.courses.entity.Question;
import com.courses.entity.Quizz;
import com.courses.entity.Response;
import com.sun.xml.ws.config.metro.parser.jsr109.ResAuthType;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.behavior.AjaxBehavior;
import javax.faces.event.AjaxBehaviorEvent;

/**
 *
 * @author sylva
 */
@ManagedBean(name = "quizz")
@RequestScoped
public class QuizzManaged extends AbstractManaged{
    
    @EJB
    private QuizzDao quizzDao;
    
    @EJB
    private CourseDao courseDao;
    
    @ManagedProperty(value="#{question}")
    private QuestionManaged questionBean;
    
    @ManagedProperty(value="#{response}")
    private ResponseManaged responseBean;
    
    private String question;
    
    private List<Response> responses;
    
    private Response response;
        
    private Courses course;

    private Quizz quizzes;
    
    public List<Response> getResponses(){
        return this.responses;
    }

    public Response getResponse() {
        return response;
    }
    
    public void addResponse(){
        responses.add(getResponse());
    }

    public void addQuestion(AjaxBehaviorEvent behavior){
        
    }
    
    public String getQuestion() {
        if(questionBean != null){
            question = questionBean.getQuestion();
        }    
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Courses getCourse() {
        return course;
    }

    public void setCourse(Courses course) {
        this.course = course;
    }

    public Quizz getQuizz() {
        return quizzes;
    }

    public void setQuizz(Quizz quizz) {
        this.quizzes = quizz;
    }
    
    @PostConstruct
    public void init(){
        String id = getContext().getRequestParameterMap().get("coursId");
        try {
            course = courseDao.find(id);
            setCourse(course);
        } catch (Exception e) {
            if (course == null) {
            }
        }
    }

    public QuestionManaged getQuestionBean() {
        return questionBean;
    }

    public void setQuestionBean(QuestionManaged questionBean) {
        this.questionBean = questionBean;
    }

    public ResponseManaged getResponseBean() {
        return responseBean;
    }

    public void setResponseBean(ResponseManaged responseBean) {
        this.responseBean = responseBean;
    }
    
}
