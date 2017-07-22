package com.gaia.menu.entities;

import java.util.LinkedList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import com.gaia.entity.entities.BaseEntity;
import javax.persistence.GeneratedValue;

/**
 *
 * @author komilo
 */
@Entity
@Table(name="app_menus")
//@Cache(usage= CacheConcurrencyStrategy.READ_WRITE)
public class Menu extends BaseEntity {

    @Id
    @Column(length=256, nullable=false, unique=true)   
    private String id;

    @Column(name="wording_key", length=256, nullable=false, unique=true)
    private String wordingKey;

    @Column(name="default_wording", length=512, nullable=false, unique=true)
    private String defaultWording;

    @Column(nullable=false)
    private boolean enabled;

    @Transient
    private boolean visible;
    
    @OneToMany(mappedBy = "parentMenu")
//    @Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
    private List<MenuItem> items = new LinkedList<MenuItem>();

    public Menu() {
        this.visible = true;
    }

    public Menu(String id) {
        this.id = id;
    }
    
    public Menu(String id, String labelKey, String defaultLabel) {
        this(id, labelKey, defaultLabel, true);
    }

    public Menu(String id, String labelKey, String defaultLabel, boolean enabled) {
        this.id = id;
        this.wordingKey = labelKey;
        this.defaultWording = defaultLabel;
        this.enabled = enabled;
        this.visible = true;
    }

    public void addItem(MenuItem item) {
        this.items.add(item);
        item.setParentMenu(this);
    }

    public String getDefaultWording() {
        return defaultWording;
    }

    public void setDefaultWording(String defaultLabel) {
        this.defaultWording = defaultLabel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public void setItems(List<MenuItem> items) {
        this.items = items;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getWordingKey() {
        return wordingKey;
    }

    public void setWordingKey(String labelKey) {
        this.wordingKey = labelKey;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Menu other = (Menu) obj;
        if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }
}
