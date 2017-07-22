/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.core.web.component.navbar;

import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

/**
 *
 * @author watt
 */
public class NotificationListView extends Panel{
    
    public NotificationListView(String id) {
        super(id);
    }

    public NotificationListView(String id, IModel<?> model) {
        super(id, model);
    }
    
    
    
}
