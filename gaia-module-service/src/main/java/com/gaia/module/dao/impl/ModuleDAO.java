/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.module.dao.impl;

import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import com.gaia.entity.dao.impl.DAO;
import com.gaia.module.dao.IModuleDAO;
import com.gaia.module.entities.Module;

/**
 *
 * @author komilo
 */
@Repository("moduleDAO")
public class ModuleDAO extends DAO<Module, String> implements IModuleDAO {

    public ModuleDAO() {
        super(Module.class);
    }

    @Override
    public Boolean exists(String name) {
        Query query = em.createQuery("SELECT COUNT(m) FROM Module m WHERE m.name = :name");
        query.setParameter("name", name);
        Long count = (Long)query.getSingleResult();
        return (count.intValue() == 1);
    }
}
