/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.security.web;

import org.apache.wicket.Application;

import org.apache.wicket.IInitializer;
import org.wicketstuff.shiro.annotation.AnnotationsShiroAuthorizationStrategy;
import org.wicketstuff.shiro.authz.ShiroUnauthorizedComponentListener;
import com.gaia.security.web.access.AccessDeniedPage;
import com.gaia.security.web.login.LoginPage;

/**
 *
 * @author komilo
 */
public class SecurityInitializer implements IInitializer {

    @Override
    public void init(Application application) {
        //         Configure Shiro
        AnnotationsShiroAuthorizationStrategy authz = new AnnotationsShiroAuthorizationStrategy();
        application.getSecuritySettings().setAuthorizationStrategy(authz);
        application.getSecuritySettings().setUnauthorizedComponentInstantiationListener(
                new ShiroUnauthorizedComponentListener(LoginPage.class, AccessDeniedPage.class, authz));
    }

    @Override
    public void destroy(Application application) {
//        throw new UnsupportedOperationException("Not supported yet.");
    }
}
