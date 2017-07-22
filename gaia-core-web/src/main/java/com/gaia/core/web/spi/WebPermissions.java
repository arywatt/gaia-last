/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.core.web.spi;

/**
 *
 * @author watt
 */
public class WebPermissions {
    
    public static final String WEB = "*";
    
    
    public static final String ADMIN = "admin:*";
    public static final String USER = "admin:user:*";
    
    
    public static final String ACCOUNT = "admin:user:account:*";   
    public static final String ACCOUNT_CREATE = "admin:user:account:create";
    public static final String ACCOUNT_EDIT = "admin:user:account:edit";
    public static final String ACCOUNT_DELETE = "admin:user:account:drop";
    public static final String ACCOUNT_VIEW = "admin:user:account:view";
    
    
    public static final String POST = "admin:user:post:*";
    public static final String POST_CREATE = "admin:user:post:create";
    public static final String POST_VIEW = "admin:user:post:view";
    public static final String POST_EDIT = "admin:user:post:edit";
    public static final String POST_DELETE = "admin:user:post:delete";
    
    
    public static final String CATEGORY_ACCOUNT = "account";
    public static final String CATEGORY_POST = "publishing";
    
    
    
    
    
    
    
    
    
}
