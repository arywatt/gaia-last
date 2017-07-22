/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.security.spi;

import java.util.Iterator;
import org.springframework.context.ApplicationContext;
import com.gaia.module.service.IModuleService;
import com.gaia.module.api.AbstractModule;
import com.gaia.entity.utils.*;
import com.gaia.security.entities.Permission;
import com.gaia.security.entities.PermissionCategory;
import com.gaia.security.entities.Role;
import com.gaia.security.service.IPermissionCategoryService;
import com.gaia.security.service.IPermissionService;
import com.gaia.security.service.IRoleService;

/**
 *
 * @author komilo
 */
public class SecurityServiceModule extends AbstractModule {

    private IModuleService moduleService;
    private IRoleService roleService;
    private IPermissionService permissionService;
    private IPermissionCategoryService permissionCategoryService;

    public SecurityServiceModule() {
        ApplicationContext context = SpringApplicationContextHolder.getContext();
        this.moduleService = context.getBean(IModuleService.class);
        this.roleService = context.getBean(IRoleService.class);
        this.permissionService = context.getBean(IPermissionService.class);
        this.permissionCategoryService = context.getBean(IPermissionCategoryService.class);
    }

    @Override
    public String name() {
        return "security-service";
    }

    @Override
    public String displayName() {
        return "Security Service";
    }

    @Override
    public String descriptionKey() {
        return "module.security-service.desc";
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
        return new String[]{"entity-service"};
    }

    @Override
    public boolean fixed() {
        return true;
    }

    @Override
    public void install() {
        super.install();
        // get api impls
        Iterator<ISecurityServiceModuleAPI> iterator =
                this.moduleService.getModuleAPIImpls(ISecurityServiceModuleAPI.class);

        while (iterator.hasNext()) {
            ISecurityServiceModuleAPI apiImpl = iterator.next();
//          

//          // add permission categories
            for (PermissionCategory permissionCategory : apiImpl.permissionCategories()) {
                
                 
                // delete all permissions to avoid a constraint key error
                this.permissionService.deleteRange(permissionCategory.getPermissions());
                
                // then delete the permission category
                this.permissionCategoryService.deleteOne(permissionCategory.getId());
                
                // then save the permission Category
                this.permissionCategoryService.saveOne(permissionCategory);
            }

            // add permissions            
            for (Permission permission : apiImpl.permissions()) {
                Permission bound = permission;
                bound.setCategory(permissionCategoryService.getOne(permission.getCategory().getId()));
//              permissionService.deleteOne(permission.getId());
                this.permissionService.saveOne(bound);
            }

            // add roles
//            for (Role role : apiImpl.roles()) {
//                
//                Role updRole = roleService.getOneByName(role.getName());
//                System.out.println("+++++++++++++++++ SecurityServiceModule " + updRole);
//                boolean save = false;
//                if (updRole == null) {
//                    updRole = new Role(role.getName());
//                    save = true;
//                }
//                updRole.setDescription(role.getDescription());
//                updRole.setFixed(role.isFixed());
//                updRole.getPermissions().clear();
//                
//                for (Permission permission : role.getPermissions()) {
//                    System.out.println("+++++++++++++ SecurityServiceModule :"+permission);
//                    Permission updPermission = permissionService.getOne(permission.getId());
//                    if (updPermission != null) {
//                        System.out.println("+++++++++++++ SecurityServiceModule :"+updPermission);
//                        updRole.getPermissions().add(updPermission);                        
//                    }
//                }
//                
//                if (save) {
//                    System.out.println("+++++++++++++ SecurityServiceModule : SAVE");
//                    roleService.saveOne(updRole);
//                } else {
//                    System.out.println("+++++++++++++ SecurityServiceModule : UPD");
//                    //roleService.updateOne(updRole);
//                }
//            }
        }
    }
}
