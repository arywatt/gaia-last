/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gaia.module.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import com.gaia.entity.entities.BaseEntity;

/**
 *
 * @author komilo
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="dtype", discriminatorType=DiscriminatorType.STRING)
@Table(name="core_plugins")
public class Plugin extends BaseEntity {

    @Id
    @Column(nullable=false)
    private String name;

    @Column(name="display_name", nullable=false)
    private String displayName;

    @Column(name="description_key", nullable=false)
    private String descriptionKey;

    @Column(name="default_description", nullable=false)
    private String defaultDescription;

    @Column(name="plugin_version", nullable=false)
    private String pluginVersion;

    @Column(nullable=false)
    private boolean enabled = false;

    public Plugin() {
    }

    public Plugin(String name) {
        this.name = name;
    }

    public Plugin(String name, String displayName, String descriptionKey, String pluginVersion) {
        this.name = name;
        this.displayName = displayName;
        this.descriptionKey = descriptionKey;
        this.pluginVersion = pluginVersion;
    }

    public String getDescriptionKey() {
        return descriptionKey;
    }

    public void setDescriptionKey(String descriptionKey) {
        this.descriptionKey = descriptionKey;
    }

    public String getDefaultDescription() {
        return defaultDescription;
    }

    public void setDefaultDescription(String defaultDescription) {
        this.defaultDescription = defaultDescription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getPluginVersion() {
        return pluginVersion;
    }

    public void setPluginVersion(String pluginVersion) {
        this.pluginVersion = pluginVersion;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Plugin other = (Plugin) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (this.name != null ? this.name.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "Plugin{" + "name=" + name + ", nameKey=" + displayName + ", descriptionKey=" + descriptionKey + ", pluginVersion=" + pluginVersion + ", enabled=" + enabled + '}';
    }
}
