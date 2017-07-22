/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.module.dao.impl;

import org.springframework.stereotype.Repository;
import com.gaia.entity.dao.impl.DAO;
import com.gaia.module.dao.IThemeDAO;
import com.gaia.module.entities.Theme;

/**
 *
 * @author komilo
 */
@Repository("themeDAO")
public class ThemeDAO extends DAO<Theme, String> implements IThemeDAO {

    public ThemeDAO() {
        super(Theme.class);
    }
}
