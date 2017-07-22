/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gaia.module.api;

import java.util.ArrayList;
import java.util.List;
import org.apache.wicket.request.resource.ResourceReference;

/**
 *
 * @author komilo
 */
public abstract class AbstractTheme implements ITheme {

    @Override
    public List<ResourceReference> getStylesheets() {
        return new ArrayList<ResourceReference>();
    }

    @Override
    public List<ResourceReference> getScripts() {
        return new ArrayList<ResourceReference>();
    }

    @Override
    public List<ResourceReference> getAfterBodyScripts() {
        return null;
    }

    @Override
    public List<ResourceReference> getBeforeBodyScripts() {
        return null;
    }

    @Override
    public ResourceReference getLogo() {
        return null;
    }

   
    @Override
    public ResourceReference getFavicon() {
        return null;
    }
}
