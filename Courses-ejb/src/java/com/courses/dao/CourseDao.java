/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.courses.dao;

import com.courses.entity.Courses;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sylva
 */
@Stateless
public class CourseDao {
    
    @PersistenceContext(name = "PU")
    private EntityManager em;
    
    public static void createCourse(String title, String content) throws Exception {
        try {
             Courses course = new Courses()
                .setTitle(title)
                .setContent(content)
                .setCreatedAt(new Date());
        
        //em.persist(course);
        } catch (Exception e) {
            throw new Exception("Impossible d'enregistrer le cours");
        }
    }
}
