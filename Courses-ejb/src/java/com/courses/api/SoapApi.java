/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.courses.api;

import com.courses.dao.CourseDao;
import com.courses.dao.UserDao;
import com.courses.entity.Courses;
import com.courses.entity.User;
import java.io.IOException;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

/**
 *
 * @author gilda
 */

@WebService(serviceName="api", name = "v1")
@Stateless
public class SoapApi {
    @EJB
    private CourseDao courseDao;
    @EJB
    private UserDao userDao;
    @Resource
    private WebServiceContext context;
    
    @WebMethod
    public List<Courses> getAllCourses(){
        return courseDao.findAll();
    }
    
    @WebMethod
    public User getUser(String username) throws JAXBException{
        try {
             return userDao.findByUsername(username);
        } 
        catch (Exception e) {
            throw new JAXBException("error", "user not valid");
        }
    }
    
    @WebMethod
    public Courses getCourse(String id) throws Exception{
        return courseDao.find(id);
    }
    
    @WebMethod
    public List<User> getAllUsers(){
        return userDao.findAll();
    }
}
