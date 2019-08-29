package com.cosmetic.cosmetic_common.exception;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CosmeticExceptionHandler {

    private static final Logger logger = Logger.getLogger(CosmeticExceptionHandler.class.getName());
    
    @ExceptionHandler(value = CosmeticException.class)
    public ResponseEntity<String> handleCosmeticException(CosmeticException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
    
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        logger.log(Level.SEVERE, "", ex);
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
