package com.ffjm.photoapp.photomicroservice.exception;

public class ResourceNotFoundException extends Exception {
    private static final long serialVersionUID = -2763617334049486573L;

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
