/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.core.web;

import com.gaia.security.entities.User;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;

/**
 *
 * @author komilo
 */
public class GaiaSession extends WebSession {

   

    private User user = null;
    
 
    
    private Map<String, Object> sessionParameters = new HashMap<String, Object> ();

    /**Menu actif*/
    private int activeMenu = 0;

   

    public GaiaSession(Request request) {
        super(request);
//        Locale locale = Locale.FRENCH;
//        this.setLocale(locale);

    }
    
    



    public static GaiaSession get() {
        return (GaiaSession) Session.get();
    }

   
//    public List<Menu> getUserMenus() {
//        return userMenus;
//    }
//
//    public void setUserMenus(List<Menu> userMenus) {
//        this.userMenus = userMenus;
//    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public int getActiveMenu() {
        return activeMenu;
    }

    public void setActiveMenu(int activeMenu) {
        this.activeMenu = activeMenu;
    }    
    
    public void put(String key, Object value) {
        sessionParameters.put(key, value);
    }
    
    public Object get(String key) {
        return sessionParameters.get(key);
    }
    
    public void remove(String key) {
        sessionParameters.remove(key);
    }
}
