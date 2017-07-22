/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.security.spi;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import com.gaia.security.entities.Permission;
import com.gaia.security.entities.PermissionCategory;
import com.gaia.security.entities.Role;

/**
 *
 * @author komilo
 */
public class SecurityServiceModuleAPIImpl implements ISecurityServiceModuleAPI {
    
    private static final String PERMISSION_CATEGORY_ID = "security";
    
    @Override
    public Collection<PermissionCategory> permissionCategories() {
        Collection<PermissionCategory> categories = new LinkedList<PermissionCategory>();
        categories.add(new PermissionCategory("security", "permission.category.security", "Sécurité"));
        return categories;
    }

    @Override
    public Collection<Permission> permissions() {
        Collection<Permission> permissions = new LinkedList<Permission>();
//        
//        permissions.add(new Permission(SecurityPermissions.MANAGE,
//                "permission.security.manage", "Gérer toute la sécurité", PERMISSION_CATEGORY_ID));
//        
//        // permissions liées aux utiisateurs
//        permissions.add(new Permission(SecurityPermissions.USER_MANAGE,
//                "permission.security.user.manage", "Gérer les utilisateurs", PERMISSION_CATEGORY_ID));
//        permissions.add(new Permission(SecurityPermissions.USER_ADD,
//                "permission.security.user.add", "Ajouter des utilisateurs", PERMISSION_CATEGORY_ID));
//        permissions.add(new Permission(SecurityPermissions.USER_EDIT,
//                "permission.security.user.edit", "Modifier des utilisateurs", PERMISSION_CATEGORY_ID));
//        permissions.add(new Permission(SecurityPermissions.USER_DELETE,
//                "permission.security.user.delete", "Supprimer des utilisateurs", PERMISSION_CATEGORY_ID));
//        permissions.add(new Permission(SecurityPermissions.USER_LIST,
//                "permission.security.user.list", "Consulter la liste des utilisateurs", PERMISSION_CATEGORY_ID));
//        permissions.add(new Permission(SecurityPermissions.USER_CHANGE_ANY_PASSWORD,
//                "permission.security.user.changeanypassword", "Modifier les mots de passe des utilisateurs", PERMISSION_CATEGORY_ID));
//        permissions.add(new Permission(SecurityPermissions.USER_CHANGE_OWN_PASSWORD,
//                "permission.security.user.changeownpassword", "Modifier son propre mot de passe", PERMISSION_CATEGORY_ID));
//        
//        // permissions liées aux rôles
//        permissions.add(new Permission(SecurityPermissions.ROLE_MANAGE,
//                "permission.security.role.manage", "Gérer les rôles", PERMISSION_CATEGORY_ID));
//        permissions.add(new Permission(SecurityPermissions.ROLE_ADD,
//                "permission.security.role.add", "Ajouter des rôles", PERMISSION_CATEGORY_ID));
//        permissions.add(new Permission(SecurityPermissions.ROLE_EDIT,
//                "permission.security.role.edit", "Modifier des rôles", PERMISSION_CATEGORY_ID));
//        permissions.add(new Permission(SecurityPermissions.ROLE_DELETE,
//                "permission.security.role.delete", "Supprimer des rôles", PERMISSION_CATEGORY_ID));
//        permissions.add(new Permission(SecurityPermissions.ROLE_LIST,
//                "permission.security.role.list", "Consulter la liste des rôles", PERMISSION_CATEGORY_ID));
//        permissions.add(new Permission(SecurityPermissions.ROLE_ASSIGN_PERMISSIONS,
//                "permission.security.role.assignpermissions", "Assigner des permissions aux rôles", PERMISSION_CATEGORY_ID));
//        
        return permissions;
    }

    @Override
    public Collection<Role> roles() {
        return Collections.EMPTY_LIST;
    }
}
