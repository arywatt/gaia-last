/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.core.web.component.panel;

import com.gaia.core.web.base.BasePage;
import com.gaia.menu.entities.Menu;
import com.gaia.menu.entities.MenuItem;
import com.gaia.menu.service.IMenuItemService;
import com.gaia.menu.service.IMenuService;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.wicket.Page;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.ResourceModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

/**
 *
 * @author watt
 */
public class MenuBlockPanel extends Panel{
    
    @SpringBean(name ="menuService")
    private IMenuService menuService;
    
   
    
    
    public MenuBlockPanel(String id) {
        super(id);
        initPanel();
    }

    public MenuBlockPanel(String id, IModel<?> model) {
        super(id, model);
        initPanel();
    }
    
    private void initPanel(){
      List<Menu> menus = new LinkedList<>();
      Iterator<Menu> it = menuService.getAll().iterator();
      while(it.hasNext()){
          Menu menu = it.next();
          if(menu.getWordingKey().contains("left")) menus.add(menu);
      };
      ListView<Menu> leftMenu = new ListView<Menu>("left-menu-list",menus) 
      {
                    @Override
                    protected void populateItem(ListItem<Menu> item) {
                        Menu menu = item.getModelObject();
                        item.setVisible(menu.isVisible());

                        item.setRenderBodyOnly(true);
                        item.add(new Label("menu-title",
                                new ResourceModel(menu.getWordingKey(), menu.getDefaultWording())));

                        ListView<MenuItem> menuItemList = new ListView<MenuItem>("menu-item-list", menu.getItems()) {

                            @Override
                            protected void populateItem(ListItem<MenuItem> item) {
                                try {
                                final MenuItem menuItem = item.getModelObject();
//                                if (!userIsPermitted(menuItem.getPermission())) {
//                                    item.setVisible(false);
//                                }
                                BookmarkablePageLink menuItemLink = new BookmarkablePageLink("menu-item-link", Class.forName(menuItem.getPageClass()));
//                                AjaxFallbackLink menuItemLink = new AjaxFallbackLink("menu-item-link") {
//
//                                    @Override
//                                    public void onClick(AjaxRequestTarget target) {
//                                        Class<Page> responseClass = null;
//                                        try {
//                                            responseClass = (Class<Page>) Class.forName(menuItem.getPageClass());
//                                        } catch (ClassNotFoundException ex) {
//                                            Logger.getLogger(BasePage.class.getName()).log(Level.SEVERE, null, ex);
//                                        }     
//                                        
////                                        getGaiaSession().setActiveMenu(getGaiaSession()
////                                                .getUserMenus().indexOf(menuItem.getParentMenu()));
////                                        setResponsePage(responseClass);
//                                    }
//                                };
                                
                                
                                menuItemLink.add(new Label("menu-item-label", new ResourceModel(menuItem.getWordingKey(), menuItem.getDefaultLabel())));
                                menuItemLink.setAutoEnable(true);
                                item.add(menuItemLink);
                                } catch (ClassNotFoundException ex) {
                                    Logger.getLogger(BasePage.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        };
                        item.add(menuItemList);
                    }

                   
      };
      
      this.add(leftMenu);
    }
    
}
