/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.watt.code.web.base;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 *
 * @author watt
 */
public class BasePage extends WebPage{

    protected String title;
    public BasePage() {
    }

    public BasePage(String title) {
        super();
        this.title = title;
        this.add(new Label("title",
                new Model<>(this.getTitle() + " - " + this.getString("page.title"))));
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    
    
}
