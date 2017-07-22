/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.module.api;

/**
 *
 * @author komilo
 */
public abstract class AbstractModule implements IModule {

    @Override
    public void plug() {
    }

    @Override
    public void unplug() {
    }

    @Override
    public void install() {
    }

    @Override
    public void uninstall() {
    }

    @Override
    public String[] dependencies() {
        return new String[] {};
    }
    
    @Override
    public boolean fixed() {
        return false;
    }
}
