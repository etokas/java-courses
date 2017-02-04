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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author sylva
 */
@Entity
@Table(name="users")
public class User implements Serializable{

    @Id
    @GeneratedValue
    private Long id;
    
    @Column
    private String firstname;
    
    @Column
    private String lastname;
    
    @Column
    private String password;
    
    @Column
    private String salt;
    
    @Column
    private String email;
    
    @Column
    private String username;
    
    @Column
    @Temporal(TemporalType.DATE)
    private Date createdAt;
    
    @OneToMany(targetEntity = Courses.class, mappedBy = "user")
    private List<Courses> coursesView;

    public String getFirstname() {
        return firstname;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getSalt() {
        return salt;
    }

    public User setSalt(String salt) {
        this.salt = salt;
        return this;
    }

    public User setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public User setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Courses> getCoursesView() {
        return coursesView;
    }

    public void setCoursesView(List<Courses> coursesView) {
        this.coursesView = coursesView;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public User setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }
    
   
    
}
