/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.security.service.impl;

import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gaia.entity.dao.IDAO;
import com.gaia.entity.service.impl.CRUDService;
import com.gaia.security.dao.IPermissionCategoryDAO;
import com.gaia.security.entities.PermissionCategory;
import com.gaia.security.service.IPermissionCategoryService;

/**
 *
 * @author komilo
 */
@Service("permissionCategoryService")
public class PermissionCategoryService extends CRUDService<PermissionCategory, String>
        implements IPermissionCategoryService {
    
    @Autowired(required=true)
    public PermissionCategoryService(IPermissionCategoryDAO dao) {
        super(dao);
    }
}
