/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gaia.security.dao.impl;

import org.springframework.stereotype.Repository;
import com.gaia.entity.dao.impl.DAO;
import com.gaia.security.dao.IPermissionDAO;
import com.gaia.security.entities.Permission;

/**
 *
 * @author komilo
 */
@Repository("permissionDAO")
public class PermissionDAO extends DAO<Permission, String> implements IPermissionDAO {

    public PermissionDAO() {
        super(Permission.class);
    }
}
