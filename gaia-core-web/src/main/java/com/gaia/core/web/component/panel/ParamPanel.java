/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.core.web.component.panel;

import com.gaia.core.web.GaiaSession;
import com.gaia.menu.entities.Menu;
import com.gaia.menu.entities.MenuItem;
import com.gaia.menu.service.IMenuService;
import java.util.List;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

/**
 *
 * @author watt
 */
public class ParamPanel extends Panel{
    
    private IMenuService menuService;
    
    public ParamPanel(String id) {
        super(id);
    }

    public ParamPanel(String id, IModel<?> model) {
        super(id, model);
        
       
    }
    
    
    
}
