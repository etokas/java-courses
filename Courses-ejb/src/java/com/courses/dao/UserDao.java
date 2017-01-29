/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.courses.dao;

import com.courses.entity.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import com.courses.utils.UserUtil;
import java.util.Date;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author sylva
 */
@Stateless
public class UserDao extends AbstractDao{
    

    public void create(String firstname, String lastname, String password, String email) throws Exception {
        
        String salt = UserUtil.generateSalt();
        
        try {
            String hashPassword = UserUtil.hashPassword(password, salt);
            User user = new User()
                    .setLastname(lastname)
                    .setFirstname(firstname)
                    .setPassword(hashPassword)
                    .setSalt(salt)
                    .setCreatedAt(new Date())
                    .setEmail(email);
            
           em.persist(user);
                                    
        } catch (Exception e) {
            throw new Exception("Impossible d'enregistrer l'utilisateur");
        }
       
    }
    
    public User findByUsername(String username) throws Exception{
        try {
            CriteriaQuery queryBuilder = getBuilder().createQuery();
            Root<User> a = queryBuilder.from(User.class);
            queryBuilder.where(getBuilder().equal(a.get("username"), username));
            Query query = em.createQuery(queryBuilder);
            return (User) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public boolean checkUser(String email, String password){
        User user = new User();
        return true;
    }
    
    public List<User> findAll() {
        Query query = em.createQuery("SELECT u FROM User u");
        List<User> users = query.getResultList();
        return users;
    }
   
}
