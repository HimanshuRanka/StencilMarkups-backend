package com.stencil.markups.Exceptions;

public class ResourceNotFoundException extends Exception {

    public ResourceNotFoundException(){
        super("The object with this id does not exist");
    }

    public ResourceNotFoundException(String message){
        super(message);
    }

}
