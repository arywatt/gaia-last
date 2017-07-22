/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gaia.module.dao;

import com.gaia.entity.dao.IDAO;
import com.gaia.module.entities.Module;

/**
 *
 * @author komilo
 */
public interface IModuleDAO extends IDAO<Module, String> {
    
    Boolean exists(String name);
    
}
