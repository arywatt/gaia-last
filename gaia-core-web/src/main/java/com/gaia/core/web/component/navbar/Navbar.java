/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.core.web.component.navbar;

import java.util.LinkedList;
import java.util.List;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.DropDownChoice;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.ResourceModel;

/**
 *
 * @author watt
 */
public class Navbar extends Panel{
    
    public Navbar(String id) {
        super(id);
        initNavbar();
    }

    public Navbar(String id, IModel<?> model) {
        super(id, model);
        
        
    }
    
    
    
    private void initNavbar(){
       
        
//       Button logbtn = new Button("logbtn");
//       logbtn.setVisible(true);
//       logbtn.add(new AttributeAppender("alt", new ResourceModel("navbar.menu.login.label")));
//       this.add(logbtn);

       Link logLink =  new Link("logLink") {
           @Override
           public void onClick() {
               
           }
       };
       logLink.add(new AttributeAppender("title", new ResourceModel("navbar.menu.login.label")));
       this.add(logLink);
       
//       Button regbtn = new Button("regbtn");
//       regbtn.setVisible(true);
//       regbtn.add(new AttributeAppender("alt", new ResourceModel("navbar.menu.register.label")));
//       this.add(regbtn);
       
       Link regLink =  new Link("regLink") {
           @Override
           public void onClick() {
               
           }
       };
       regLink.add(new AttributeAppender("title", new ResourceModel("navbar.menu.register.label")));
       this.add(regLink);
       
       
//       Button parambtn = new Button("parambtn1");
//       parambtn.setVisible(true);
//       parambtn.add(new AttributeAppender("alt", new ResourceModel("navbar.menu.settings.label")));
//       this.add(parambtn);
       
       Link paramLink = new Link("paramLink") {
           @Override
           public void onClick() {
               
           }
       };
       paramLink.add(new AttributeAppender("title", new ResourceModel("navbar.menu.settings.label")));
       this.add(paramLink);
       
       
//       Button parambtnCaret = new Button("parambtn2");
//       parambtn.setVisible(true);       
//       this.add(parambtnCaret);
       
       LinkedList<String> langs = new LinkedList<>();
       langs.add("English");
       langs.add("Italian");
       DropDownChoice<String> langChoices = new DropDownChoice<>("lang", new Model(langs));
       langChoices.setLabel(new ResourceModel("navbar.menu.language.label"));
      
       
       Form form = new Form("form", new CompoundPropertyModel(new Model()));
       form.add(langChoices);
       this.add(form);
       
       this.add(new BookmarkablePageLink("homeLink", this.getApplication().getHomePage()));
       this.add(new BookmarkablePageLink("userHome", this.getApplication().getHomePage()));

       
       
    }
    /**
     * To add a new css Attribute to the component markup
     * If the attribute already exist 
     * it will be overwritten
     * If you don't want to overwrite use the appendStyle method
     * 
     * @param attribute
     * @param value 
     */
    
    public void addStyle(String attribute, String value ){
        this.add(new AttributeModifier(attribute, value));   
    }  
    
    /**
     * To add a new css Attribute to the component markup
     * Does not modify existing attribute
     * 
     * @param attribute
     * @param value 
     */
    public void appendStyle(String attribute, String value ){
        this.add(new AttributeAppender(attribute, value));   
    }

    private void loadNotificationPanel() {
//        NotificationPanel p = new NotificationPanel("notifPanel");
    }

    private void loadMenuPanel() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void loadParamPanel() {
       
    }

    private void loadAuthPanel() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    
    
    
}
