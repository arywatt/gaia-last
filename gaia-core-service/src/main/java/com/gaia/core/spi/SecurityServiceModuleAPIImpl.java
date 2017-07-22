/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.core.spi;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import com.gaia.security.entities.Permission;
import com.gaia.security.entities.PermissionCategory;
import com.gaia.security.entities.Role;
import com.gaia.security.spi.ISecurityServiceModuleAPI;

/**
 *
 * @author komilo
 */
public class SecurityServiceModuleAPIImpl implements ISecurityServiceModuleAPI {
    
    private static final String PERMISSION_CATEGORY_ID = "core";

    @Override
    public Collection<PermissionCategory> permissionCategories() {
        Collection<PermissionCategory> categories = new LinkedList<PermissionCategory>();
        categories.add(new PermissionCategory(PERMISSION_CATEGORY_ID
                , "permission.category.core", "Core"));
        return categories;
    }

    @Override
    public Collection<Permission> permissions() {
        Collection<Permission> permissions = new LinkedList<Permission>();
        permissions.add(new Permission(CorePermissions.MANAGE, "permission.manage",
                "Tout faire! (Attention)", PERMISSION_CATEGORY_ID));
        return permissions;
    }

    @Override
    public Collection<Role> roles() {
        Collection<Role> roles = new LinkedList<Role>();
        Role role = new Role(CoreServiceModule.SUPER_USER_ROLE_NAME, 
                "Les utilisateurs ayant ce rôle peuvent tout faire.", true);
        role.getPermissions().add(new Permission(CorePermissions.MANAGE));
        roles.add(role);
        return roles;
    }
    
}
