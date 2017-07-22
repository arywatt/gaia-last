/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.menu.dao.impl;

import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import com.gaia.entity.dao.impl.DAO;
import com.gaia.menu.dao.IMenuItemDAO;
import com.gaia.menu.entities.MenuItem;

/**
 *
 * @author komilo
 */
@Repository("menuItemDAO")
public class MenuItemDAO extends DAO<MenuItem, Integer> implements IMenuItemDAO {

    public MenuItemDAO() {
        super(MenuItem.class);
    }

    @Override
    public Boolean exists(String wordingKey) {
        Query query = em.createQuery("SELECT COUNT(m) FROM MenuItem m WHERE m.wordingKey = :wordingKey");
        query.setParameter("wordingKey", wordingKey);
        Long count = (Long) query.getSingleResult();
        return (count.intValue() == 1);
    }

    @Override
    public MenuItem getOneByWordingKey(String wordingKey) {
        Query query = em.createQuery("SELECT m FROM MenuItem m WHERE m.wordingKey = :wordingKey");
        query.setParameter("wordingKey", wordingKey);        
        return (MenuItem) query.getSingleResult();
    }
}
