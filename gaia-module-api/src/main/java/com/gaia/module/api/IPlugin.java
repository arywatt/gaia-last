/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gaia.module.api;

import java.io.Serializable;

/**
 *
 * @author komilo
 */
public interface IPlugin extends Serializable {

    String name();

    String displayName();

    String descriptionKey();

    String defaultDescription();

    String version();
}
