/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.entity.exception;

/**
 *
 * @author komilo
 */
public class BusinessException extends RuntimeException {
    
    private String module;
    
    private Object exceptionObject;

    public BusinessException(String module) {
        this.module = module;
    }

    public BusinessException(String module, String message) {
        super(message);
        this.module = module;
    }

    public BusinessException(String module, Throwable cause) {
        super(cause);
        this.module = module;
    }

    public BusinessException(String module, String message, Throwable cause) {
        super(message, cause);
        this.module = module;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public Object getExceptionObject() {
        return exceptionObject;
    }

    public void setExceptionObject(Object exceptionObject) {
        this.exceptionObject = exceptionObject;
    }
}
