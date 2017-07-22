/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.menu.dao;

import com.gaia.entity.dao.IDAO;
import com.gaia.menu.entities.MenuItem;

/**
 *
 * @author komilo
 */
public interface IMenuItemDAO extends IDAO<MenuItem, Integer> {

    Boolean exists(String wordingKey);
    
    MenuItem getOneByWordingKey(String wordingKey);
    
}
