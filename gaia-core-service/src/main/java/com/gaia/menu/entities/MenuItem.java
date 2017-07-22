package com.gaia.menu.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//import org.hibernate.annotations.Cache;
//import org.hibernate.annotations.CacheConcurrencyStrategy;
import com.gaia.entity.entities.BaseEntity;
import com.gaia.security.entities.Permission;

/**
 *
 * @author komilo
 */
@Entity
@Table(name="app_menus_items")
//@Cache(usage= CacheConcurrencyStrategy.READ_WRITE)
public class MenuItem  extends BaseEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="wording_key", length=128, nullable=false)
    private String wordingKey;

    @Column(name="wording_label", length=512, nullable=false)
    private String defaultWording;

    @Column(name="page_class", nullable=false)
    private String pageClass;

    @Column(nullable=false)
    private boolean enabled;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="permission")
    private Permission permission;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="app_menu_parent_id")
    private Menu parentMenu;

    public MenuItem() {
    }

    public MenuItem(String wordingKey, String defaultWording, String pageClass) {
        this(wordingKey, defaultWording, pageClass, true, "");
    }

    public MenuItem(String wordingKey, String defaultWording, String pageClass,
            String permissionId) {
        this(wordingKey, defaultWording, pageClass, true, permissionId);
    }

    public MenuItem(String wordingKey, String defaultWording, String pageClass,
            boolean  enabled, String permissionId) {
        this(wordingKey, defaultWording, pageClass, enabled, new Permission(permissionId));
    }
    
    public MenuItem(String wordingKey, String defaultWording, String pageClass,
            boolean  enabled, String permissionId, String parentMenuId) {
        this(wordingKey, defaultWording, pageClass, enabled, new Permission(permissionId));
        this.parentMenu = new Menu(parentMenuId);
    }

    public MenuItem(String wordingKey, String defaultWording, String pageClass,
            boolean  enabled, Permission permission) {
        this.wordingKey = wordingKey;
        this.defaultWording = defaultWording;
        this.pageClass = pageClass;
        this.enabled = enabled;
        this.permission = permission;
    }

    public String getDefaultLabel() {
        return defaultWording;
    }

    public void setDefaultLabel(String defaultWording) {
        this.defaultWording = defaultWording;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public void setWordingKey(String wordingKey) {
        this.wordingKey = wordingKey;
    }

    public String getPageClass() {
        return pageClass;
    }

    public void setPageClass(String pageClass) {
        this.pageClass = pageClass;
    }

    public Menu getParentMenu() {
        return parentMenu;
    }

    public void setParentMenu(Menu parentMenu) {
        this.parentMenu = parentMenu;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MenuItem other = (MenuItem) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }
}
