/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.core.web.component;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 *
 * @author watt
 */
public class Footer extends Panel{
    

    public Footer(String id) {
        super(id);
    }

    public Footer(String id, IModel<?> model) {
        super(id, model);
    }
    
    public void initFooter(){
        
        
    }
    
}
