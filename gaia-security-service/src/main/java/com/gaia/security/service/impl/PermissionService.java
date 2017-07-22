/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gaia.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gaia.entity.service.impl.CRUDService;
import com.gaia.security.dao.IPermissionDAO;
import com.gaia.security.entities.Permission;
import com.gaia.security.service.IPermissionService;

/**
 *
 * @author komilo
 */
@Service("permissionService")
public class PermissionService extends CRUDService<Permission, String> implements IPermissionService {
    
    @Autowired(required=true)
    public PermissionService(IPermissionDAO dao) {
        super(dao);
    }
}
