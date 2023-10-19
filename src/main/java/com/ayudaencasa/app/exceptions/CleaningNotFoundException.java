
package com.ayudaencasa.app.exceptions;

public class CleaningNotFoundException extends RuntimeException{
  
    public CleaningNotFoundException() {
        super("Cleaning was not found");
    }

    public CleaningNotFoundException(String msg) {
        super(msg);
    }
    
    
}
