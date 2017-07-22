/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gaia.security.entities;

//import javax.persistence.Basic;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.gaia.entity.entities.BaseEntity;

/**
 *
 * @author komilo
 */
@Entity
@Table(name = "permissions")
public class Permission extends BaseEntity {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(nullable = false, length = 256)
    private String id;

    @Column(name = "wording_key", nullable = true)
    private String wordingKey;

    @Column(name = "default_wording", nullable = true)
    private String defaultWording;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = true)
    private PermissionCategory category;
    
    public Permission() {
    }

    public Permission(String id) {
        this.id = id;
    }

    public Permission(String id, String wordingKey, String defaultWording) {
        this.id = id;
        this.wordingKey = wordingKey;
        this.defaultWording = defaultWording;
    }

    public Permission(String id, String wordingKey, String defaultWording,
            String categoryId) {
        this.id = id;
        this.wordingKey = wordingKey;
        this.defaultWording = defaultWording;
        this.category = new PermissionCategory(categoryId);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PermissionCategory getCategory() {
        return category;
    }

    public void setCategory(PermissionCategory category) {
        this.category = category;
    }

    public String getDefaultWording() {
        return defaultWording;
    }

    public void setDefaultWording(String defaultWording) {
        this.defaultWording = defaultWording;
    }

    public String getWordingKey() {
        return wordingKey;
    }

    public void setWordingKey(String wordingKey) {
        this.wordingKey = wordingKey;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Permission)) {
            return false;
        }
        Permission other = (Permission) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Permission{" + "id=" + id + ", wordingKey=" + wordingKey + ", defaultWording=" + defaultWording + ", category=" + category + '}';
    }
}
