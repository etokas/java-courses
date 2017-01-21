/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.courses.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author sylva
 */
@Entity
public class Courses implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    
    @Column
    private String title;
    
    @Column
    private String content;
    
    @OneToMany(targetEntity = Quizz.class, mappedBy = "course")
    private List<Quizz> quizzes;
    
    @ManyToOne
    private User user;
    
    @Column
    private Date createdAt;
   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public Courses setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Courses setContent(String content) {
        this.content = content;
        return this;
    }

    public List<Quizz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(List<Quizz> quizzes) {
        this.quizzes = quizzes;
    }

    public User getUser() {
        return user;
    }

    public Courses setUser(User user) {
        this.user = user;
        return this;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Courses setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }
   
}
