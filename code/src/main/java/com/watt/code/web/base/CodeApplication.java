/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.watt.code.web.base;

import com.watt.code.web.pages.HomePage;
import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

/**
 *
 * @author watt
 */
public class CodeApplication extends WebApplication{

    @Override
    public Class<? extends Page> getHomePage() {
        return HomePage.class; //To change body of generated methods, choose Tools | Templates.
    }
    
}
