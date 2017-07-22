/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.security.web.login;

import com.gaia.core.web.GaiaSession;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.apache.shiro.SecurityUtils;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.wicketstuff.shiro.component.LoginPanel;

import com.gaia.menu.entities.Menu;
import com.gaia.menu.entities.MenuItem;
import com.gaia.menu.service.IMenuService;
import com.gaia.security.service.IUserService;

/**
 *
 * @author komilo
 */
public class GaiaLoginPanel extends LoginPanel {

    @SpringBean(name = "menuService")
    private IMenuService menuService;
    
    @SpringBean(name = "userService")
    private IUserService userService;

    public GaiaLoginPanel(String id) {
        super(id, false);
//        this.add(new FMLocaleDropDown("locale"));
    }

    @Override
    protected void onSignInSucceeded() {       
//        List<Menu> menus = this.menuService.getAll("defaultWording");
//        for (Menu menu : menus) {
//            menu.setVisible(false);
//            for (MenuItem mi : menu.getItems()) {
//                if (SecurityUtils.getSubject().isPermitted(mi.getPermission().getId())) {
//                    menu.setVisible(true);
//                }
//            }
//            Collections.sort(menu.getItems(), new Comparator<MenuItem>() {
//
//                public int compare(MenuItem o1, MenuItem o2) {
//                    return o1.getDefaultLabel().compareTo(o2.getDefaultLabel());
//                }
//            });
//        }
//            GaiaSession.get().setUserMenus(menus);
             
            GaiaSession.get().setUser(this.userService.getCurrent());
            this.setResponsePage(getApplication().getPageFactory().newPage(
                    getApplication().getHomePage()));
            
        }
    }
