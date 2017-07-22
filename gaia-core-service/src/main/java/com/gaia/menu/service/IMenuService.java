/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gaia.menu.service;

import java.util.List;
import com.gaia.entity.service.ICRUDService;
import com.gaia.menu.entities.Menu;

/**
 *
 * @author komilo
 */
public interface IMenuService extends ICRUDService<Menu, String> {

    List<Menu> getUserMenus();
    
    Boolean exists(String id);
}
