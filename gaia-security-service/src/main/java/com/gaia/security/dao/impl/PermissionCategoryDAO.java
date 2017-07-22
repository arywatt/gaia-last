/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.security.dao.impl;

import java.io.Serializable;
import org.springframework.stereotype.Repository;
import com.gaia.entity.dao.impl.DAO;
import com.gaia.security.dao.IPermissionCategoryDAO;
import com.gaia.security.entities.PermissionCategory;

/**
 *
 * @author komilo
 */
@Repository("permissionCategoryDAO")
public class PermissionCategoryDAO extends DAO<PermissionCategory, String> 
        implements IPermissionCategoryDAO {

    public PermissionCategoryDAO() {
        super(PermissionCategory.class);
    }
}
