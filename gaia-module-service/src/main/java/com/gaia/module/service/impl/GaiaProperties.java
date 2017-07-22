/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.module.service.impl;

import java.io.Serializable;

/**
 *
 * @author komilo
 */
public class GaiaProperties implements Serializable {
    
    private String sharedPath;
    
    private String classPathRoot;
    
    private String configFilePath;
    
    private ModuleProperties modules;
    
    private ThemeProperties themes;
    
    private FileProperties files;

    public GaiaProperties() {
        this.modules = new ModuleProperties();
        this.themes = new ThemeProperties();
        this.files = new FileProperties();
    }

    public String getClassPathRoot() {
        return classPathRoot;
    }

    public void setClassPathRoot(String classPathRoot) {
        this.classPathRoot = classPathRoot;
    }

    public String getConfigFilePath() {
        return configFilePath;
    }

    public void setConfigFilePath(String configFilePath) {
        this.configFilePath = configFilePath;
    }

    public FileProperties getFiles() {
        return files;
    }

    public void setFiles(FileProperties files) {
        this.files = files;
    }

    public ModuleProperties getModules() {
        return modules;
    }

    public void setModules(ModuleProperties modules) {
        this.modules = modules;
    }

    public String getSharedPath() {
        return sharedPath;
    }

    public void setSharedPath(String sharedPath) {
        this.sharedPath = sharedPath;
    }

    public ThemeProperties getThemes() {
        return themes;
    }

    public void setThemes(ThemeProperties themes) {
        this.themes = themes;
    }
    
    public class ModuleProperties implements Serializable {

        private String rootPath;
        
        private boolean installOnInit;
        
        public ModuleProperties() {
        }

        public boolean isInstallOnInit() {
            return installOnInit;
        }

        public void setInstallOnInit(boolean installOnInit) {
            this.installOnInit = installOnInit;
        }

        public String getRootPath() {
            return rootPath;
        }

        public void setRootPath(String rootPath) {
            this.rootPath = rootPath;
        }
    }
    
    public class ThemeProperties implements Serializable {
        
        private String rootPath;

        public ThemeProperties() {
        }

        public String getRootPath() {
            return rootPath;
        }

        public void setRootPath(String rootPath) {
            this.rootPath = rootPath;
        }
    }
    
    public class FileProperties implements Serializable {
        
        private String rootPath;
        
        private String picturesPath;

        public FileProperties() {
        }

        public String getPicturesPath() {
            return picturesPath;
        }

        public void setPicturesPath(String picturesPath) {
            this.picturesPath = picturesPath;
        }

        public String getRootPath() {
            return rootPath;
        }

        public void setRootPath(String rootPath) {
            this.rootPath = rootPath;
        }
    }
}
