/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.menu.service.impl;

import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gaia.entity.dao.IDAO;
import com.gaia.entity.service.impl.CRUDService;
import com.gaia.menu.dao.IMenuItemDAO;
import com.gaia.menu.entities.MenuItem;
import com.gaia.menu.service.IMenuItemService;

/**
 *
 * @author komilo
 */
@Service("menuItemService")
public class MenuItemService extends CRUDService<MenuItem, Integer> implements IMenuItemService {
    
    @Autowired(required=true)
    public MenuItemService(IMenuItemDAO dao) {
        super(dao);
    }
    
    private IMenuItemDAO getDAO() {
        return (IMenuItemDAO) this.dao;
    } 

    @Override
    public Boolean exists(String wordingKey) {
        return getDAO().exists(wordingKey);
    }

    @Override
    public MenuItem getOneByWordingKey(String wordingKey) {
        return getDAO().getOneByWordingKey(wordingKey);
    }
}
