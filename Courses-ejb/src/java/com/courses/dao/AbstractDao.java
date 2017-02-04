/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.courses.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;

/**
 *
 * @author sylva
 */
abstract public class AbstractDao {
    
        
    @PersistenceContext
    EntityManager em;
    
    public CriteriaBuilder getBuilder() {
        return em.getCriteriaBuilder();
    }
}
