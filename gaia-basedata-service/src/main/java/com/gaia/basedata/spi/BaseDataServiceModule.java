/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.basedata.spi;

import com.gaia.module.api.AbstractModule;


/**
 *
 * @author yeena
 */
public class BaseDataServiceModule extends AbstractModule {

    @Override
    public String name() {
        return "basedata-service";
    }

    @Override
    public String displayName() {
        return "Base Data Service";
    }

    @Override
    public String descriptionKey() {
        return "module.basedata-service.desc";
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
    public String[] dependencies() {
        return new String[] {"security-service"};
    }
    
    @Override
    public boolean fixed() {
        return true;
    }
}
