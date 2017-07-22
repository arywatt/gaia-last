/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gaia.core.dao;

import com.gaia.core.entities.Variable;
import com.gaia.entity.dao.IDAO;

/**
 *
 * @author komilo
 */
public interface IVariableDAO extends IDAO<Variable, String> {
        String getValue(String name);
}
