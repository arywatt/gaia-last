/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gaia.module.service;

import java.util.Iterator;
import com.gaia.entity.service.ICRUDService;
import com.gaia.module.api.ITheme;
import com.gaia.module.entities.Theme;

/**
 *
 * @author komilo
 */
public interface IThemeService extends ICRUDService<Theme, String> {

    Iterator<ITheme> getPlugins();

//    void initPlugins(WebApplication webApplication);
}
