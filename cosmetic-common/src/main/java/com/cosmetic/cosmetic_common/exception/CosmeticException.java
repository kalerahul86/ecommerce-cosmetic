package com.cosmetic.cosmetic_common.exception;

public class CosmeticException extends Exception {

    private static final long serialVersionUID = -5570701995885130260L;

    public CosmeticException(Exception ex) {
        super(ex);
    }
    
    public CosmeticException(String errorCode) {
       
    }
}
