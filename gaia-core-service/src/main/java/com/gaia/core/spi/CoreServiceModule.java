/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.core.spi;

import java.util.Iterator;
import org.springframework.context.ApplicationContext;
import com.gaia.core.entities.Variable;
import com.gaia.core.service.IVariableService;
import com.gaia.entity.utils.SpringApplicationContextHolder;
import com.gaia.menu.entities.Menu;
import com.gaia.menu.entities.MenuItem;
import com.gaia.menu.service.IMenuItemService;
import com.gaia.menu.service.IMenuService;
import com.gaia.module.api.AbstractModule;
import com.gaia.module.service.IModuleService;
import com.gaia.security.entities.User;
import com.gaia.security.service.IPermissionService;
import com.gaia.security.service.IRoleService;
import com.gaia.security.service.IUserService;

/**
 *
 * @author komilo
 */
public class CoreServiceModule extends AbstractModule {

    public static final String SUPER_USER_ROLE_NAME = "super-utilisateur";
    public static final String SUPER_USER_NAME = "admin";
    public static final String SUPER_USER_PASS = "admin";
    private IModuleService moduleService;
    private IRoleService roleService;
    private IUserService userService;
    private IPermissionService permissionService;
    private IMenuService menuService;
    private IMenuItemService menuItemService;
    private IVariableService variableService;

    public CoreServiceModule() {
        ApplicationContext context = SpringApplicationContextHolder.getContext();
        this.moduleService = context.getBean(IModuleService.class);
        this.menuService = context.getBean(IMenuService.class);
        this.menuItemService = context.getBean(IMenuItemService.class);
        this.permissionService = context.getBean(IPermissionService.class);
        this.roleService = context.getBean(IRoleService.class);
        this.userService = context.getBean(IUserService.class);
        this.variableService = context.getBean(IVariableService.class);
    }

    @Override
    public String name() {
        return "core-service";
    }

    @Override
    public String displayName() {
        return "Core Service";
    }

    @Override
    public String descriptionKey() {
        return "module.core-service.desc";
    }

    @Override
    public String defaultDescription() {
        return "";
    }

    @Override
    public String version() {
        return "1.x-1.0";
    }

    @Override
    public String[] dependencies() {
        return new String[]{"entity-service", "security-service"};
    }

    @Override
    public boolean fixed() {
        return true;
    }

    @Override
    public void install() {
        super.install();
        // get api impls
        Iterator<ICoreServiceModuleAPI> iterator =
                this.moduleService.getModuleAPIImpls(ICoreServiceModuleAPI.class);
        while (iterator.hasNext()) {
            ICoreServiceModuleAPI apiImpl = iterator.next();
            
            // add variables
            for (Variable variable : apiImpl.variables()) {
                if (! this.variableService.exist(variable.getName())) {
                    this.variableService.saveOne(variable);
                }
            }
            
            // add menus
            for (Menu menu : apiImpl.menus()) {
                if (menuService.exists(menu.getId())) {
                    Menu updMenu = menuService.getOne(menu.getId());
                    updMenu.setDefaultWording(menu.getDefaultWording());
                    updMenu.setEnabled(menu.isEnabled());
                    updMenu.setWordingKey(menu.getWordingKey());
                    this.menuService.updateOne(updMenu);
                } else {
                    this.menuService.saveOne(menu);
                }
            }
            // add menu items
            for (MenuItem menuItem : apiImpl.menuItems()) {

                if (menuItemService.exists(menuItem.getWordingKey())) {
                    MenuItem updMenuItem = menuItemService.getOneByWordingKey(menuItem.getWordingKey());
                    updMenuItem.setDefaultLabel(menuItem.getDefaultLabel());
                    updMenuItem.setEnabled(menuItem.isEnabled());
                    updMenuItem.setPageClass(menuItem.getPageClass());
                    updMenuItem.setParentMenu(menuItem.getParentMenu());
                    updMenuItem.setPermission(menuItem.getPermission());
                    updMenuItem.setWordingKey(menuItem.getWordingKey());
                    updMenuItem.setParentMenu(menuService.getOne(menuItem.getParentMenu().getId()));
                    updMenuItem.setPermission(permissionService.getOne(menuItem.getPermission().getId()));
                    this.menuItemService.updateOne(updMenuItem);
                } else {
                    menuItem.setParentMenu(menuService.getOne(menuItem.getParentMenu().getId()));
                    menuItem.setPermission(permissionService.getOne(menuItem.getPermission().getId()));
                    this.menuItemService.saveOne(menuItem);
                }
            }
        }

//        //Adding Administrator user
//        if (userService.findByUsername(SUPER_USER_NAME) == null) {
//            User superUser = new User(SUPER_USER_NAME, SUPER_USER_PASS, true);
//            superUser.getRoles().add(roleService.getOneByName(SUPER_USER_ROLE_NAME));
//            userService.saveOne(superUser);
//        }
    }

    @Override
    public void plug() {
        super.plug();
    }

    @Override
    public void unplug() {
        super.unplug();
    }

    @Override
    public void uninstall() {
        super.uninstall();

        // get api impls
        Iterator<ICoreServiceModuleAPI> iterator =
                this.moduleService.getModuleAPIImpls(ICoreServiceModuleAPI.class);
        while (iterator.hasNext()) {
            ICoreServiceModuleAPI apiImpl = iterator.next();
            // delete menu items
            this.menuItemService.deleteRange(apiImpl.menuItems());
            // delete menus
            this.menuService.deleteRange(apiImpl.menus());
        }
    }
}
