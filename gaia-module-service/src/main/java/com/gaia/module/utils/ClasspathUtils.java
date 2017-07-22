
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.module.utils;

//~--- JDK imports ------------------------------------------------------------
import java.io.File;
import java.io.IOException;

import java.lang.reflect.Method;

import java.net.URL;
import java.net.URLClassLoader;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author komilo
 */
public class ClasspathUtils {

    private static final Logger logger = Logger.getLogger(ClasspathUtils.class.getName());
    private static final Class[] parameters = new Class[]{URL.class};

    /**
     * Adds the jars in the given directory to classpath
     * @param directory
     * @throws IOException
     */
    public static ClassLoader addDirToClasspath(File directory, ClassLoader loader)
            throws IOException {
        MyURLClassLoader cl = new MyURLClassLoader((URLClassLoader) loader);//ClassLoader.getSystemClassLoader());
        if (directory.exists()) {
            for (File file : directory.listFiles()) {
                URL url = file.toURI().toURL();
                URL[] urls = cl.getURLs();
                boolean urlAdded = false;
                
                for (int i = 0; i < urls.length; i++) {
                    if (urls[i].toString().equalsIgnoreCase(url.toString())) {
                        logger.log(Level.INFO, "URL {0} is already in CLASSPATH.", url);
                        urlAdded = true;
                    }
                }
                if (urlAdded) {
                    continue;
                }

                if (file.getName().endsWith(".jar")) {
                    cl.addURL(url);
                    logger.log(Level.INFO, "URL {0} added to CLASSPATH.", url);
                }
            }
        } else {
            logger.log(Level.WARNING, "The directory ''{0}'' does not exist.", directory);
        }
        
        URL[] urls = cl.getURLs();
        for (int i = 0; i < urls.length; i++) {
            System.out.println(urls[i]);
        }
        
        return cl;
//        if (directory.exists()) {
//            File[] files = directory.listFiles();
//            for (int i = 0; i < files.length; i++) {
//                addURL(files[i].toURI().toURL());
//            }
//        } else {
//            logger.log(Level.WARNING, "The directory ''{0}'' does not exist.", directory);
//        }
    }

    /**
     * Add URL to CLASSPATH.
     * @param url URL
     * @throws IOException IOException
     */
    public static void addURL(URL url) throws IOException {
        URLClassLoader sysLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
        URL[] urls = sysLoader.getURLs();

        for (int i = 0; i < urls.length; i++) {
            if (urls[i].toString().equalsIgnoreCase(url.toString())) {                
                logger.log(Level.INFO, "URL {0} is already in CLASSPATH.", url);
                return;
            }
        }

        Class sysClass = URLClassLoader.class;

        try {
            Method method = sysClass.getDeclaredMethod("addURL", parameters);

            method.setAccessible(true);
            method.invoke(sysLoader, new Object[]{url});
            logger.log(Level.INFO, "URL {0} added to CLASSPATH.", url);
        } catch (Throwable t) {
//            t.printStackTrace();
            throw new IOException("Error, could not add URL to system classloader.");
        }
    }

    private static class MyURLClassLoader extends URLClassLoader {
        
        private URLClassLoader classLoader;

        public MyURLClassLoader(URLClassLoader classLoader) {
            super(classLoader.getURLs());
            this.classLoader = classLoader;
        }

        @Override
        public void addURL(URL url) {
            super.addURL(url);
//            this.classLoader.
        }
    }
}
