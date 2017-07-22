/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gaia.module.dao.impl;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import com.gaia.entity.dao.impl.DAO;
import com.gaia.module.dao.IPluginDAO;
import com.gaia.module.entities.Plugin;

/**
 *
 * @author komilo
 */
@Repository("pluginDAO")
public class PluginDAO extends DAO<Plugin, String> implements IPluginDAO {

    public PluginDAO() {
        super(Plugin.class);
    }

    @Override
    public boolean exists(String pluginName, Class<? extends Plugin> pluginClass) {
        return this.getOneByName(pluginName, pluginClass) != null;
    }

    @Override
    public boolean isEnabled(String pluginName, Class<? extends Plugin> pluginClass) {
        Plugin plugin = this.getOneByName(pluginName, pluginClass);
        return plugin != null && plugin.isEnabled();
    }

    @Override
    public Plugin getOneByName(String pluginName, Class<? extends Plugin> pluginClass) {
        String jpql = "SELECT p FROM " + pluginClass.getSimpleName()
                + " p WHERE p.nameKey=:nameKey";
        Query query = em.createQuery(jpql);
        query.setParameter("nameKey", pluginName);
        try {
            return (Plugin) query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }
}
