/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.core.service.impl;

import org.apache.wicket.util.file.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gaia.core.dao.IVariableDAO;
import com.gaia.core.service.ICoreConfigService;
import com.gaia.core.spi.CoreConstants;
import com.gaia.security.entities.UserDetails;

/**
 *
 * @author komilo
 */
@Service("coreConfigService")
public class CoreConfigService implements ICoreConfigService {
    
    private IVariableDAO variableDAO;
    
    private String picturesDirectoryPath;

    @Autowired
    public CoreConfigService(IVariableDAO variableDAO) {
        this.variableDAO = variableDAO;
        String basePath = this.variableDAO.getValue(CoreConstants.VARIABLE_FILES_BASE_PATH_NAME);
        String picturesFolder = this.variableDAO.getValue(CoreConstants.VARIABLE_FILES_PICTURE_FOLDER_NAME);
        this.picturesDirectoryPath = basePath + "/" + picturesFolder;
    }

    public String getPicturesDirectoryPath() {
        return this.picturesDirectoryPath;
    }
    
    public String getPicturePath(UserDetails person) {
        return this.picturesDirectoryPath + "/" + person.getId() + ".jpg";
    }
}
