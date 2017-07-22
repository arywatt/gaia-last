/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.core.web.pages;

import com.gaia.core.web.base.BasePage;
import com.gaia.core.web.component.panel.InitPanel;
import com.gaia.core.web.component.panel.MenuBlockPanel;
import org.wicketstuff.shiro.ShiroConstraint;
import org.wicketstuff.shiro.annotation.ShiroSecurityConstraint;

/**
 *
 * @author watt
 */

//@ShiroSecurityConstraint(constraint = ShiroConstraint.IsAuthenticated)
public class HomePage extends BasePage{

    public HomePage() {
       super();
       
       this.add(new MenuBlockPanel("left-block-menu"));
       this.add(new InitPanel("initPanel"));
    }
    
    
    
    

    public HomePage(String title) {
        super(title);
    }
    
    
    
    
    
}
