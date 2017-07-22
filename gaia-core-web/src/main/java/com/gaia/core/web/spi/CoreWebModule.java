/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.core.web.spi;

import com.gaia.module.api.AbstractModule;

/**
 *
 * @author watt
 */
public class CoreWebModule extends AbstractModule{

    @Override
    public String name() {
        return "core-web";
    }

    @Override
    public String displayName() {
        return "Core Web";
    }

    @Override
    public String descriptionKey() {
        return "module.core-web.desc";
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

    @Override
    public String[] dependencies() {
         return new String[] {"entity-service"}; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
