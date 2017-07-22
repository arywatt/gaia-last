/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.core.spi;

import java.util.Collection;
import com.gaia.core.entities.Variable;
import com.gaia.menu.entities.Menu;
import com.gaia.menu.entities.MenuItem;

/**
 *
 * @author komilo
 */
public interface ICoreServiceModuleAPI {
    
    Collection<Menu> menus();
    
    Collection<MenuItem> menuItems();
    
    Collection<Variable> variables();
}
