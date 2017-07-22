/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.menu.service;

import com.gaia.entity.service.ICRUDService;
import com.gaia.menu.entities.MenuItem;

/**
 *
 * @author komilo
 */
public interface IMenuItemService extends ICRUDService<MenuItem, Integer> {
    
    Boolean exists(String wordingKey);
    
    MenuItem getOneByWordingKey(String wordingKey);
    
}
