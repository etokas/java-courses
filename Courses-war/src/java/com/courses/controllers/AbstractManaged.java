/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.courses.controllers;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author sylva
 */
public class AbstractManaged {
    
    public static ExternalContext getContext(){
        return  FacesContext.getCurrentInstance().getExternalContext();
    }
}
