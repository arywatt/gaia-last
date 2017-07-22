/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.entity.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 *
 * @author komilo
 */
public class SpringApplicationContextHolder implements ApplicationContextAware {

    /** Contexte Spring qui sera injecte par Spring directement */
    private static ApplicationContext context = null;

    /**
     * Méthode de ApplicationContextAware, qui sera appellée automatiquement par le conteneur
     */
    @Override
    public void setApplicationContext(ApplicationContext ctx)
            throws BeansException {
        context = ctx;
    }

    /**
     * Methode statique pour récupérer le contexte
     */
    public static ApplicationContext getContext() {
        return context;
    }
}
