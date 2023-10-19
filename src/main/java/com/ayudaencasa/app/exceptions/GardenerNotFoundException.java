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
public class GardenerNotFoundException extends RuntimeException {
    
    public GardenerNotFoundException() {
        super("Gardener was not found");
    }

    public GardenerNotFoundException(String msg) {
        super(msg);
    }
    
}
