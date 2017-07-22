/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.menu.service.impl;

import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gaia.entity.service.impl.CRUDService;
import com.gaia.menu.dao.IMenuDAO;
import com.gaia.menu.entities.Menu;
import com.gaia.menu.entities.MenuItem;
import com.gaia.menu.service.IMenuService;
import com.gaia.security.entities.Permission;
import com.gaia.security.service.IUserService;

/**
 *
 * @author komilo
 */
@Service("menuService")
@Transactional
public class MenuService extends CRUDService<Menu, String> implements IMenuService {

    private IUserService userService;

    @Autowired(required = true)
    public MenuService(IMenuDAO dao, IUserService userService) {
        super(dao);
        this.userService = userService;
    }

    private IMenuDAO getDAO() {
        return (IMenuDAO) this.dao;
    }    
    
    @Override
    public List<Menu> getUserMenus() {
        List<Menu> menus = this.getAll();
        List<Menu> userMenus = new LinkedList<Menu>();
        List<MenuItem> userMenuItems = null;
        List<MenuItem> menuItems = null;
        Menu userMenu = null;
        MenuItem userMenuItem = null;
        for (Menu menu : menus) {
            userMenu = new Menu();
            userMenuItems = new LinkedList<MenuItem>();
            menuItems = menu.getItems();
            for (MenuItem menuItem : menuItems) {
                userMenuItem = new MenuItem();
                userMenuItem.setId(menuItem.getId());
                userMenuItem.setWordingKey(menuItem.getWordingKey());
                userMenuItem.setDefaultLabel(menuItem.getDefaultLabel());
                userMenuItem.setPageClass(menuItem.getPageClass());
                userMenuItem.setParentMenu(userMenu);
                userMenuItem.setPermission(
                        new Permission(menuItem.getPermission().getId(),
                        menuItem.getPermission().getWordingKey(),
                        menuItem.getPermission().getDefaultWording()));
                if (this.userService.userIsPermitted(userMenuItem.getPermission())) {

                    userMenuItems.add(userMenuItem);
                    //menu.getItems().remove(menuItem);
                }
            }
            if (!userMenuItems.isEmpty()) {
                userMenu.setId(menu.getId());
                userMenu.setWordingKey(menu.getWordingKey());
                userMenu.setDefaultWording(menu.getDefaultWording());
                userMenu.setItems(menuItems);

                userMenus.add(userMenu);
                //menus.remove(menu);
            }
        }
        return userMenus;
    }

    @Override
    public Boolean exists(String id) {
        return getDAO().exists(id);
    }

   
    
}
