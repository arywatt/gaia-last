/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.module.service.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ServiceLoader;
import javax.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gaia.entity.service.impl.CRUDService;
import com.gaia.module.api.IModule;
import com.gaia.module.dao.IModuleDAO;
import com.gaia.module.entities.Module;
import com.gaia.module.service.IModuleService;
import java.util.logging.Logger;

/**
 *
 * @author komilo
 */
@Service("moduleService")
public class ModuleService extends CRUDService<Module, String> implements IModuleService {

//    private static ModuleService pluginService;
    private static final Logger logger = Logger.getLogger(ModuleService.class.getName());
    private Collection<String> installed;
    private Collection<IModule> iModules;

    @Autowired
    private ModuleService(IModuleDAO dao) {
        super(dao);        
        
        this.installed = new HashSet<String>();        
        this.iModules = new LinkedList<IModule>();
       
    }

    private IModuleDAO getDAO() {
        return (IModuleDAO) this.dao;
    }

//    public static IModuleService getInstance() {
//        if (pluginService == null) {
////            pluginService = new ModuleService();
//        }
//        return pluginService;
//    }
    @Override
    public void loadModules() {
        // add jars
        //this.addModuleJarsToClassPath();
        
        // load modules
        this.iModules.clear();
        Iterator<IModule> iterator = this.getIModules();
       
        System.out.println("ablabla Modules size:"+iterator.hasNext() );
        while (iterator.hasNext()) {
            IModule im = iterator.next();
            System.out.println("++++++++++++++++ ModuleService :" + im);
            this.iModules.add(im);
        }

        // install modules
        this.installed.clear();
        for (IModule imodule : this.iModules) {
            this.install(imodule);
        }
        
        this.installed.clear();
        this.iModules.clear();
    }

    private void addModuleJarsToClassPath() {
//        try {
//            //String moduleDirPath = SpringPropertiesUtil.getProperty("app.modules.rootPath");
//            //System.out.println("+++++++ MODULE SERVICE : " + SpringPropertiesUtil.getProperty("app.modules.rootPath"));
//            File file = new File("/home/yeena/scholar/modules");
//            ClasspathUtils.addDirToClasspath(file);
//        } catch (IOException ex) {
//            
//        }
    }

    @Override
    public Iterator<IModule> getIModules() {
        ServiceLoader<IModule> serviceLoader = ServiceLoader.load(IModule.class);
        return serviceLoader.iterator();
    }

    @Override
    public <T> Iterator<T> getModuleAPIImpls(Class<T> apiClass) {
        ServiceLoader<T> serviceLoader = ServiceLoader.load(apiClass);
        return serviceLoader.iterator();
    }

    private IModule getIModule(String name) {
        for (IModule imodule : this.iModules) {
            if (imodule != null && imodule.name() != null
                    && imodule.name().equals(name)) {
                return imodule;
            }
        }
        return null;
    }

    @Override
    public void install(IModule imodule) {        
        if (imodule == null || this.installed.contains(imodule.name())) {
            for(int i=0;i<20;i++){
                System.out.println("**********************************************************");
            }
            return;
        }        
        
        Module module = new Module();

        // install dependencies
        for (String name : imodule.dependencies()) {
            this.install(this.getIModule(name));
            System.out.println("+++++++++++++++ ModuleService :" + imodule.name() +"-->"+name);
            module.getDependencies().add(this.dao.getOne(name));
        }
        
        boolean moduleExists = this.getDAO().exists(imodule.name());
        // update module entity
        if (moduleExists){
            module = this.dao.getOne(imodule.name());
        }
        module.setName(imodule.name());
        module.setDisplayName(imodule.displayName());
        module.setDescriptionKey(imodule.descriptionKey());
        module.setDefaultDescription(imodule.defaultDescription());
        module.setPluginVersion(imodule.version());
        module.setFixed(imodule.fixed());
        module.setEnabled(true);
        
        if (moduleExists){
            this.dao.updateOne(module);
        } else {
            this.dao.saveOne(module);            
        }

        // update dependencies

        // call install()
        imodule.install();

        // call plug()
        imodule.plug();

        // mark module ass installed
        this.installed.add(imodule.name());
    }

    @Override
    public boolean isInstalled(String moduleName) {
        try {
            Module module = this.getDAO().getOne(moduleName);
            return module != null;
        } catch (NoResultException ex) {
            return false;
        }
    }
}
