/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gaia.module.api;

/**
 *
 * @author komilo
 */
public interface IModule extends IPlugin {

    void plug();

    void unplug();

    void install();

    void uninstall();

    String[] dependencies();
    
    boolean fixed();
}
