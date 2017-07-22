/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gaia.module.service;

import java.util.Iterator;
import com.gaia.entity.service.ICRUDService;
import com.gaia.module.api.IModule;
import com.gaia.module.entities.Module;

/**
 *
 * @author komilo
 */
public interface IModuleService extends ICRUDService<Module, String> {

    Iterator<IModule> getIModules();
    
    <T> Iterator<T> getModuleAPIImpls(Class<T> apiClass);
    
    void loadModules();
    
    void install(IModule moduleIface);
    
    boolean isInstalled(String moduleName);

//    void initPlugins(WebApplication webApplication);
}
