/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.security.web.spi;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import com.gaia.core.entities.Variable;
import com.gaia.core.spi.ICoreServiceModuleAPI;
import com.gaia.menu.entities.Menu;
import com.gaia.menu.entities.MenuItem;
import com.gaia.security.spi.SecurityPermissions;

/**
 *
 * @author komilo
 */
public class CoreServiceModuleAPIImpl implements ICoreServiceModuleAPI {

    @Override
    public Collection<Variable> variables() {
        return Collections.EMPTY_LIST;
    }

    @Override
    public Collection<Menu> menus() {
        return Collections.EMPTY_LIST;
    }

    @Override
    public Collection<MenuItem> menuItems() {
        Collection<MenuItem> items = new LinkedList<MenuItem>();
//        items.add(new MenuItem("menu.security.user", "Utilisateurs",
//                com.gaia.security.web.admin.user.ListPage.class.getName(),
//                true, SecurityPermissions.USER_LIST, "admin"));
//        items.add(new MenuItem("menu.security.role", "Rôles",
//                com.gaia.security.web.admin.role.ListPage.class.getName(),
//                true, SecurityPermissions.USER_LIST, "admin"));
        return items;
    }
    
}
