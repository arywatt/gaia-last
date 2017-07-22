/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.entity.utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 *
 * @author komilo
 */
public class SpringPropertiesUtil extends PropertyPlaceholderConfigurer {

    private static Map<String, String> propertiesMap = new HashMap<String, String>();

    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactory,
            Properties props) throws BeansException {
        super.processProperties(beanFactory, props);
        
        for (Object key : props.keySet()) {
            String keyStr = key.toString();            
            propertiesMap.put(keyStr, parseStringValue(props.getProperty(keyStr),
                    props, new HashSet()));           
        }
    }

    public static String getProperty(String name) {
        return propertiesMap.get(name);
    }
}
