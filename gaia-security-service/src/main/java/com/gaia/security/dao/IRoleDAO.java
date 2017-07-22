/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gaia.security.dao;

import com.gaia.entity.dao.IDAO;
import com.gaia.security.entities.Role;

/**
 *
 * @author komilo
 */
public interface IRoleDAO extends IDAO<Role, Long> {
    
    Role getOneByName(String name);
    
}
