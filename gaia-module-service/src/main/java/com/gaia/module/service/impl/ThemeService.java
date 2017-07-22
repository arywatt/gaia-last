/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gaia.module.service.impl;

import java.util.Iterator;
import java.util.ServiceLoader;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gaia.entity.service.impl.CRUDService;
import com.gaia.module.api.ITheme;
import com.gaia.module.dao.IThemeDAO;
import com.gaia.module.entities.Theme;
import com.gaia.module.service.IThemeService;

/**
 *
 * @author komilo
 */
@Service("themeService")
public class ThemeService extends CRUDService<Theme, String> implements IThemeService {

    private static ThemeService pluginService;
    private ServiceLoader<ITheme> serviceLoader;
    private static final Logger logger = Logger.getLogger(ThemeService.class.getName());

    @Autowired
    private ThemeService(IThemeDAO dao) {
        super(dao);
        //load all the classes in the classpath that have implemented the interface
        serviceLoader = ServiceLoader.load(ITheme.class);
    }

    public static IThemeService getInstance() {
        if (pluginService == null) {
//            pluginService = new ThemeService();
        }
        return pluginService;
    }

    @Override
    public Iterator<ITheme> getPlugins() {
        return serviceLoader.iterator();
    }

//    public void initPlugins(WebApplication webApplication) {
//        Iterator<ITheme> iterator = getPlugins();
//        if (!iterator.hasNext()) {
//            logger.info("No plugins were found!");
//        }
//        while (iterator.hasNext()) {
//            ITheme plugin = iterator.next();
//            logger.log(Level.INFO, "Initializing the plugin {0}", plugin.name());
//            plugin.initWicketApplication(webApplication);
//        }
//    }
}
