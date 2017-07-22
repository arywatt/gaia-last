/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.entity.spi;

import com.gaia.module.api.AbstractModule;

/**
 *
 * @author komilo
 */
public class EntityServiceModule extends AbstractModule  {

    @Override
    public String name() {
        return "entity-service";
    }

    @Override
    public String displayName() {
        return "Entity Service";
    }

    @Override
    public String descriptionKey() {
        return "module.entity-service.desc";
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
        return new String[] {};
    }

    @Override
    public boolean fixed() {
        return true;
    }
}
