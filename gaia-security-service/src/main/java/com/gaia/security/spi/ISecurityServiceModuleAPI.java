/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gaia.security.spi;

import java.util.Collection;
import com.gaia.security.entities.Permission;
import com.gaia.security.entities.PermissionCategory;
import com.gaia.security.entities.Role;

/**
 *
 * @author komilo
 */
public interface ISecurityServiceModuleAPI {

    Collection<PermissionCategory> permissionCategories();

    Collection<Permission> permissions();

    Collection<Role> roles();
}
