/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gaia.security.service;

import com.gaia.entity.service.ICRUDService;
import com.gaia.security.entities.Permission;
import com.gaia.security.entities.Role;
import com.gaia.security.entities.User;

/**
 *
 * @author komilo
 */
public interface IUserService extends ICRUDService<User, Long> {

    User getCurrent();

    User findByUsername(String username);

    void enable(User user);

    void disable(User user);
    
    void changePassword(Long userId, String newPassword);

    boolean userIsPermitted(String permission);

    boolean userIsPermitted(Permission permission);

    boolean userHasRole(String role);

    boolean userHasRole(Role role);
    
    boolean isUserPermitted(User user, Permission permission);
}
