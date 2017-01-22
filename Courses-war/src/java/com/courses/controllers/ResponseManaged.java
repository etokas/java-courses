/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.courses.controllers;

import com.courses.entity.Response;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author sylva
 */
@ManagedBean(name = "response")
@RequestScoped
public class ResponseManaged {
    
    private List<Response> responses;

    public List<Response> getResponses() {
        return responses;
    }

    public void addResponse(Response response) {
        responses.add(response);
    }
    
}
