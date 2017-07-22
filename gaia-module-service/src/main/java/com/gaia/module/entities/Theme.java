/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gaia.module.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author komilo
 */
@Entity
@DiscriminatorValue("T")
public class Theme extends Plugin {

    public Theme() {
    }

    public Theme(String name, String nameKey, String descriptionKey, String pluginVersion) {
        super(name, nameKey, descriptionKey, pluginVersion);
    }
}
