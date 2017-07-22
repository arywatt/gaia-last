/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.core.web.base;

import com.gaia.core.web.component.Footer;
import com.gaia.core.web.component.navbar.Navbar;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;
import org.apache.wicket.request.resource.PackageResourceReference;


/**
 *
 * @author watt
 */
public class BasePage extends WebPage{
    
    private String title;

    public BasePage() {
        this("GAIA");
    }
    
    public BasePage(String title){
        this.title = title;
        
        Navbar nav = new Navbar("header");
        
        this.add(nav);
        
        Footer footer = new Footer("footer");
        this.add(footer);
        
        
        
        
    }
    
    @Override
     public void renderHead(IHeaderResponse response) {
        super.renderHead(response);

//    response.render(CssHeaderItem.forReference(new CssResourceReference(BasePage.class,"theme/css/bootstrap.min.css"))); 
//    response.render(CssHeaderItem.forReference(new CssResourceReference(BasePage.class,"theme/css/bootstrap-theme.min.css"))); 
//    response.render(CssHeaderItem.forReference(new CssResourceReference(BasePage.class,"theme/css/style-base.css"))); 
//    response.render(JavaScriptHeaderItem.forReference(new JavaScriptResourceReference(BasePage.class, "theme/js/jquery-2.1.3.min.js"))); 
//    response.render(JavaScriptHeaderItem.forReference(new JavaScriptResourceReference(BasePage.class, "theme/js/bootstrap.min.js"))); 
//    response.render(JavaScriptHeaderItem.forReference(new JavaScriptResourceReference(BasePage.class, "theme/js/bootstrap-select.js"))); 
//    
//    
    
}

   
    
    
    
    
   
    
}

//