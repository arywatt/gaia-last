/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gaia.core.service;

import com.gaia.core.entities.Variable;
import com.gaia.entity.service.ICRUDService;

/**
 *
 * @author komilo
 */
public interface IVariableService extends ICRUDService<Variable, String> {
    
    String getValue(String name);
    
//    Semester getActiveSemester();

}
