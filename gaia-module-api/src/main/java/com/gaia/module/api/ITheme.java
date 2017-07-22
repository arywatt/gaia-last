/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gaia.module.api;

import java.util.List;
import org.apache.wicket.request.resource.ResourceReference;

/**
 *
 * @author komilo
 */
public interface ITheme extends IPlugin {

    List<ResourceReference> getStylesheets();

    List<ResourceReference> getScripts();

    List<ResourceReference> getBeforeBodyScripts();

    List<ResourceReference> getAfterBodyScripts();

    ResourceReference getLogo();

    ResourceReference getFavicon();
}
