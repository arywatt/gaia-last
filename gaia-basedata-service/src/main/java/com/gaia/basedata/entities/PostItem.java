/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.basedata.entities;

import java.util.Objects;
import java.util.logging.Logger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author watt
 */

@Entity
@Table(name="post_items")
public class PostItem {
    
    public final static String IMAGE_ITEM = "img";
    public final static String VIDEO_ITEM = "video";
    public final static String TEXT_ITEM = "text";
   
    private static final long serialVersionUID = 1L;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(name = "item_title",length = 150,nullable = true)
    private String itemTitle;
    
    @Column(name = "name",length = 150,nullable = false)
    private String name;
    
    @Column(name = "path",length = 150,nullable = true)
    private String path;
    
    @OneToOne(mappedBy = "postItem",fetch = FetchType.LAZY)
    private Post relatedPost;
    
    
    @Column(name = "type",length = 150,nullable = false)
    private String type;

    public PostItem() {
    }

    public PostItem(String itemTitle, String type) {
        this.itemTitle = itemTitle;
        this.type = type;
    }

    public PostItem(String itemTitle, String name, String path, String type) {
        this.itemTitle = itemTitle;
        this.name = name;
        this.path = path;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.id);
        hash = 37 * hash + Objects.hashCode(this.itemTitle);
        hash = 37 * hash + Objects.hashCode(this.name);
        hash = 37 * hash + Objects.hashCode(this.path);
        hash = 37 * hash + Objects.hashCode(this.type);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PostItem other = (PostItem) obj;
        if (!Objects.equals(this.itemTitle, other.itemTitle)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.path, other.path)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PostItem{" + "id=" + id + ", itemTitle=" + itemTitle + ", name=" + name + ", path=" + path + ", type=" + type + '}';
    }
    
    
    
    
    
    
    
}
