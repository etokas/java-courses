/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.courses.controllers;

import com.courses.entity.Question;
import com.courses.entity.Response;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author sylva
 */
@ManagedBean(name = "question")
@RequestScoped
public class QuestionManaged {
    
    private String question;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
   
    
}
