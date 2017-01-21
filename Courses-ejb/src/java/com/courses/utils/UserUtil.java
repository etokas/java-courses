/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.courses.utils;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.MessageDigest;
import org.apache.xml.security.utils.Base64;

/**
 *
 * @author sylva
 */
public class UserUtil {
    
    public static String generateSalt() throws NoSuchAlgorithmException{
        SecureRandom secure = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        secure.nextBytes(salt);
        return Base64.encode(salt);
    }
    
    public static String hashPassword(String password, String salt) {
        String hashPassword = null;
        
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(salt.getBytes());
            byte[] bytes = md.digest(password.getBytes());
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                builder.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            hashPassword = builder.toString();
            
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        
        return hashPassword;
    }
}
