package com.gaia.security.web.login;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

/**
 *
 * @author komilo
 */
public class LoginPage extends WebPage {

    public LoginPage() {
        this.add(new Label("title", this.getString("page.title") + " - " + this.getString("app.displayName")));
        this.add(new GaiaLoginPanel("loginPanel"));
    }
}
