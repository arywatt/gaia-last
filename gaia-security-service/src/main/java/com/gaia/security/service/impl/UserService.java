/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.security.service.impl;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gaia.entity.exception.BusinessException;
import com.gaia.entity.service.impl.CRUDService;
import com.gaia.security.dao.IUserDAO;
import com.gaia.security.entities.Permission;
import com.gaia.security.entities.Role;
import com.gaia.security.entities.User;
import com.gaia.security.service.IUserService;

/**
 *
 * @author komilo
 */
@Service("userService")
@Transactional
public class UserService extends CRUDService<User, Long> implements IUserService {

    @Autowired(required = true)
    public UserService(IUserDAO dao) {
        super(dao);
    }

    private IUserDAO getDAO() {
        return (IUserDAO) this.dao;
    }

    @Override
    public synchronized User saveOne(User t) {
        t.setPassword(new Sha256Hash(t.getPassword()).toHex());
        return super.saveOne(t);
    }

    @Override
    public synchronized User updateOne(User t) {
        try {
            User user = this.dao.getOne(t.getId());
            t.setPassword(user.getPassword());
            return super.updateOne(t);
        } catch (Exception ex) {
            throw new BusinessException("security", "Echec lors de la mise à jour.", ex);
        }
    }
    
    @Override
    public synchronized void changePassword(Long userId, String newPassword) {
        this.getDAO().updatePassowrd(userId, new Sha256Hash(newPassword).toHex());
    }

    @Override
    public synchronized User getCurrent() {
        return this.getOne((Long)SecurityUtils.getSubject().getPrincipal());
    }

    @Override
    public synchronized boolean userIsPermitted(Permission permission) {
        return this.userIsPermitted(permission.getId());
    }

    public synchronized boolean userIsPermitted(String permissionId) {
        return SecurityUtils.getSubject().isPermitted(permissionId);
    }

    public synchronized boolean userHasRole(Role role) {
        return this.userHasRole(role.getName());
    }

    public synchronized boolean userHasRole(String role) {
        return SecurityUtils.getSubject().hasRole(role);
    }

    public synchronized void disable(User user) {
        user.setEnabled(false);
        this.dao.updateOne(user);
    }

    public synchronized void enable(User user) {
        user.setEnabled(true);
        this.dao.updateOne(user);
    }

    public synchronized User findByUsername(String username) {
        return this.getDAO().findByUsername(username);
    }
    
    public synchronized boolean isUserPermitted(User user, Permission permission){
        for (Role role : user.getRoles()) {
           if (role.getPermissions().contains(permission)) {
               return true;
           }
        }  
        return false;
    }
}
