/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.security.spi;

/**
 *
 * @author komilo
 */
public class SecurityPermissions {
    
    public static final String MANAGE = "security:*";
    
    public static final String USER_MANAGE = "security:user:*";
    
    public static final String USER_LIST = "security:user:list";
    public static final String USER_ADD = "security:user:add";
    public static final String USER_EDIT = "security:user:edit";
    public static final String USER_DELETE = "security:users:delete";
    public static final String USER_CHANGE_OWN_PASSWORD = "security:user:changeownpassword";
    public static final String USER_CHANGE_ANY_PASSWORD = "security:user:changeownpassword:any";
    
    public static final String ROLE_MANAGE = "security:role:*";
    
    public static final String ROLE_LIST = "security:role:list";
    public static final String ROLE_ADD = "security:role:add";
    public static final String ROLE_EDIT = "security:role:edit";
    public static final String ROLE_DELETE = "security:role:delete";
    public static final String ROLE_ASSIGN_PERMISSIONS = "security:role:assign";
}
