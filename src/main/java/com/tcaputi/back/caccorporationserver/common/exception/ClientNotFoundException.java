package com.tcaputi.back.caccorporationserver.common.exception;

public class ClientNotFoundException extends RuntimeException {
    public ClientNotFoundException(String message) {
        super(message);
    }
}
