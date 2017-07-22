/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gaia.security.service;

import com.gaia.entity.service.ICRUDService;
import com.gaia.security.entities.Role;

/**
 *
 * @author komilo
 */
public interface IRoleService extends ICRUDService<Role, Long> {
    
    Role getOneByName(String name);

}
