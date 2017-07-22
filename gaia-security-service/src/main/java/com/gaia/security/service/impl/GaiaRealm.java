/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.security.service.impl;

import java.util.Set;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.Sha256CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.gaia.security.dao.IUserDAO;
import com.gaia.security.entities.Permission;
import com.gaia.security.entities.Role;
import com.gaia.security.entities.User;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.springframework.context.ApplicationContext;

/**
 * The Spring/Hibernate sample application's one and only configured Apache Shiro Realm.
 *
 * <p>Because a Realm is really just a security-specific DAO, we could have just made Hibernate calls directly
 * in the implementation and named it a 'HibernateRealm' or something similar.</p>
 *
 * <p>But we've decided to make the calls to the database using a UserDAO, since a DAO would be used in other areas
 * of a 'real' application in addition to here. We felt it better to use that same DAO to show code re-use.</p>
 *
 * @author komilo
 */
@Component("gaiaRealm")
public class GaiaRealm extends AuthorizingRealm {

    @Autowired(required=true)
    protected IUserDAO userDAO;

    public GaiaRealm() {
        setName("gaiaRealm"); //This name must match the name in the User class's getPrincipals() method
        setCredentialsMatcher(new Sha256CredentialsMatcher());
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
            throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        User user = userDAO.findByUsername(token.getUsername());
        if (user != null) {
            return new SimpleAuthenticationInfo(user.getId(), user.getPassword(), getName());
        } else {
            return null;
        }
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Long userId = (Long) principals.fromRealm(this.getName()).iterator().next();
        User user = userDAO.getOne(userId);
        if (user != null) {
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            for (Role role : user.getRoles()) {
                info.addRole(role.getName());
                Set<Permission> permissions = role.getPermissions();
                for (Permission permission : permissions) {
                    info.addStringPermission(permission.getId());
                }
            }
            return info;
        } else {
            return null;
        }
    }

    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }
}
