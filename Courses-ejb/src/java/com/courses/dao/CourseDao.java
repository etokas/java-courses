/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.courses.dao;

import com.courses.entity.Courses;
import com.courses.exception.DaoException;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author sylva
 */
@Stateless
public class CourseDao extends AbstractDao{
    
    public void createCourse(String title, String content) throws Exception {
        try {
             Courses course = new Courses()
                .setTitle(title)
                .setContent(content)
                .setCreatedAt(new Date());
        
            em.persist(course);
        } catch (Exception e) {
            throw new Exception("Impossible d'enregistrer le cours");
        }
    }
    
    public List<Courses> findAll(){
        CriteriaQuery cquery = getBuilder().createQuery();
        Root e = cquery.from(Courses.class);
        Query query = em.createQuery(cquery);
        return (List<Courses>) query.getResultList();
    }
    
    public Courses find(String id) throws Exception{
        CriteriaQuery cquery = getBuilder().createQuery();
        Root e = cquery.from(Courses.class);
        cquery.where(getBuilder().equal(e.get("id"), id));
        Courses courses;
        try {
            Query query = em.createQuery(cquery);
            return courses = (Courses) query.getSingleResult();
        } catch (Exception ex) {
            return null;

        }
    }
}
