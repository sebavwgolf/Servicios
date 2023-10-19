/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ayudaencasa.app.exceptions;

/**
 *
 * @author Usr
 */
public class OtherNotFoundException extends RuntimeException {
    
    public OtherNotFoundException() {
        super("Other was not found");
    }

    public OtherNotFoundException(String msg) {
        super(msg);
    }
    
}
