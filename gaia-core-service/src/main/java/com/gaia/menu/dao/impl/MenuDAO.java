/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gaia.menu.dao.impl;

import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import com.gaia.entity.dao.impl.DAO;
import com.gaia.menu.dao.IMenuDAO;
import com.gaia.menu.entities.Menu;

/**
 *
 * @author komilo
 */
@Repository("menuDAO")
public class MenuDAO extends DAO<Menu, String> implements IMenuDAO {

    public MenuDAO() {
        super(Menu.class);
    }

    @Override
    public Boolean exists(String id) {
        Query query = em.createQuery("SELECT COUNT(m) FROM Menu m WHERE m.id = :id");
        query.setParameter("id", id);
        Long count = (Long)query.getSingleResult();
        return (count.intValue() == 1);
    }

    
    
}
