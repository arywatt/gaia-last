/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.core.spi;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import com.gaia.core.entities.Variable;
import com.gaia.core.spi.ICoreServiceModuleAPI;
import com.gaia.menu.entities.Menu;
import com.gaia.menu.entities.MenuItem;

/**
 *
 * @author komilo
 */
public class CoreServiceModuleAPIImpl implements ICoreServiceModuleAPI {

    public Collection<Variable> variables() {
        List<Variable> liste = new LinkedList<Variable>();
//        liste.add(new Variable(CoreConstants.VARIABLE_ACTIVE_SEMESTER_NAME, "10", "10"));
        liste.add(new Variable(CoreConstants.VARIABLE_FILES_BASE_PATH_NAME,
                "/var/gaia", "/var/gaia"));
        liste.add(new Variable(CoreConstants.VARIABLE_FILES_PICTURE_FOLDER_NAME,
                "pictures", "pictures"));
        return liste;
    }

    @Override
    public Collection<Menu> menus() {
        return Collections.EMPTY_LIST;
    }

    @Override
    public Collection<MenuItem> menuItems() {
        return Collections.EMPTY_LIST;
    }
    
}
