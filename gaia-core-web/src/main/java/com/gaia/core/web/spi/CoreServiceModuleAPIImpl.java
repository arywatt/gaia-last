/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.core.web.spi;

import com.gaia.core.entities.Variable;
import com.gaia.core.spi.ICoreServiceModuleAPI;
import com.gaia.core.web.pages.HomePage;
import com.gaia.menu.entities.Menu;
import com.gaia.menu.entities.MenuItem;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

/**
 *
 * @author watt
 */
public class CoreServiceModuleAPIImpl implements ICoreServiceModuleAPI{

    @Override
    public Collection<Menu> menus() {
        LinkedList<Menu> menus = new LinkedList<>();
        menus.add(new Menu("menu.navbar.settings", "menu.navbar.settings","settings",true ));
        menus.add(new Menu("menu.navbar.dashboard", "menu.navbar.dashboard","dashboard",true ));
        menus.add(new Menu("menu.navbar.main", "menu.navbar.main","main",true ));
        menus.add(new Menu("menu.navbar.note", "menu.navbar.note","note",true ));
        
        menus.add(new Menu("menu.left.category", "menu.left.category","categories",true ));
        
        
        return menus;
    }

    @Override
    public Collection<MenuItem> menuItems() {
       LinkedList<MenuItem> items = new LinkedList<>();
        
        
       items.add(new MenuItem("menu.left.category.artnculture", "Art&Culture",HomePage.class.getCanonicalName(), true,WebPermissions.USER,"menu.left.category"));
       items.add(new MenuItem("menu.left.category.landscape", "Landscape",HomePage.class.getCanonicalName(), true,WebPermissions.USER,"menu.left.category"));
       items.add(new MenuItem("menu.left.category.food", "Food",HomePage.class.getCanonicalName(), true,WebPermissions.USER,"menu.left.category"));
       items.add(new MenuItem("menu.left.category.people", "People",HomePage.class.getCanonicalName(), true,WebPermissions.USER,"menu.left.category"));
       items.add(new MenuItem("menu.left.category.sport", "Sport",HomePage.class.getCanonicalName(), true,WebPermissions.USER,"menu.left.category"));
       items.add(new MenuItem("menu.left.category.university", "University",HomePage.class.getCanonicalName(), true,WebPermissions.USER,"menu.left.category"));
       
       return items;
    }

    @Override
    public Collection<Variable> variables() {
         return Collections.EMPTY_LIST;
    }
    
}
