/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gaia.module.dao;

import com.gaia.entity.dao.IDAO;
import com.gaia.module.entities.Plugin;

/**
 *
 * @author komilo
 */
public interface IPluginDAO extends IDAO<Plugin, String> {

    Plugin getOneByName(String pluginNameKey, Class<? extends Plugin> pluginClass);

    boolean exists(String pluginNameKey, Class<? extends Plugin> pluginClass);

    boolean isEnabled(String pluginNameKey, Class<? extends Plugin> pluginClass);
}
