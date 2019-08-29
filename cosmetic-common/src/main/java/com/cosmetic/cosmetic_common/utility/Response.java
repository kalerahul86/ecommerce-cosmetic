package com.cosmetic.cosmetic_common.utility;

public class Response {

    private String message;
    private String statusCode;
    
    public Response(String statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
    
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
   
}
