/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.core.web.spi;

import com.gaia.security.entities.Permission;
import com.gaia.security.entities.PermissionCategory;
import com.gaia.security.entities.Role;
import com.gaia.security.spi.ISecurityServiceModuleAPI;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author watt
 */
public class SecurityServiceModuleAPIImpl implements ISecurityServiceModuleAPI{

    @Override
    public Collection<PermissionCategory> permissionCategories() {
       List<PermissionCategory> categories = new LinkedList<>();
       categories.add(new PermissionCategory("account","web.permission.account.category","account category"));
       categories.add(new PermissionCategory("publishing","web.permission.post.category","post category"));
               
       return categories;
    }

    @Override
    public Collection<Permission> permissions() {
        List<Permission> permissions = new LinkedList<>();
        permissions.add(new Permission(WebPermissions.ACCOUNT, "web.permission.account","account", WebPermissions.CATEGORY_ACCOUNT));
        permissions.add(new Permission(WebPermissions.POST, "web.permission.post","post",WebPermissions.CATEGORY_POST));
        
       return permissions;
    }

    @Override
    public Collection<Role> roles() {
         List<Role> roles = new LinkedList<>();
         Role user = new Role("user","Normal user", true);
         Role admin = new Role("admin","Admin", true);
         Role superAdmin = new Role("super.user","Super User", true);
         Role pageAdmin  = new Role("page.admin","Page administrator", true);
         Role groupAdmin  = new Role("group.admin","Group administrator", true);
         Role pageFollower  = new Role("page.follower","Page follower", true);
         Role groupMember  =new Role("group.member","Group member", true);
         
//         user.addPermission(WebPermissions.USER);
//         admin.addPermission(WebPermissions.ADMIN);
         
        
        
       return Collections.EMPTY_LIST;
    }
    
}
