/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.security.web.spi;

import com.gaia.module.api.AbstractModule;

/**
 *
 * @author komilo
 */
public class SecurityWebModule extends AbstractModule {

    @Override
    public String name() {
        return "security-web";
    }

    @Override
    public String displayName() {
        return "Security Web";
    }

    @Override
    public String descriptionKey() {
        return "module.security-web.desc";
    }

    @Override
    public String defaultDescription() {
        return "";
    }

    @Override
    public String version() {
        return "1.x-1.0";
    }

    @Override
    public boolean fixed() {
        return true;
    }
    
}
