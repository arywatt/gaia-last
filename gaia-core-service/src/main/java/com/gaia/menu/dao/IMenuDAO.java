/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gaia.menu.dao;

import com.gaia.entity.dao.IDAO;
import com.gaia.menu.entities.Menu;

/**
 *
 * @author komilo
 */
public interface IMenuDAO extends IDAO<Menu, String> {
    
    Boolean exists(String id);

}
