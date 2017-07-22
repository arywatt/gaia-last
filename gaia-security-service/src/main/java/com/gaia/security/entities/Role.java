package com.gaia.security.entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.Table;
//import org.hibernate.annotations.Cache;
//import org.hibernate.annotations.CacheConcurrencyStrategy;
//import org.hibernate.annotations.Index;
//import org.eclipse.persistence.annotations.Index;
import com.gaia.entity.entities.BaseEntity;

@Entity
@Table(name="roles")
//@Cache(usage= CacheConcurrencyStrategy.READ_WRITE)
public class Role extends BaseEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Basic(optional=false)
    @Column(length=100, nullable=false, unique=true)
//    @Index(name="idx_roles_name")
    private String name;

    @Basic(optional=false)
    @Column(nullable=true, length=1024)
    private String description;

    @Basic(optional=false)
    @Column(nullable=false)
    private boolean fixed;
    
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="roles_permissions", joinColumns = @JoinColumn(name = "role_id"),
        inverseJoinColumns = @JoinColumn(name = "permission_id"))
//    @Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
    private Set<Permission> permissions = new HashSet<Permission>();

    public Role() {
    }

    public Role(String name) {
        this(name, name, false);
    }

    public Role(String name, String description) {
        this(name, description, false);
    }

    public Role(String name, String description, boolean fixed) {
        this.name = name;
        this.description = description;
        this.fixed = fixed;
    }
    
    @PostPersist
    public void trace() {
        System.out.println("+++++++++++++++++ Role persist " + this);
    }
    
    @PostUpdate
    public void trace2() {
        System.out.println("+++++++++++++++++ Role Update " + this);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Role other = (Role) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "Role{" + "id=" + id + "name=" + name + "description=" + description + "fixed=" + fixed + '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isFixed() {
        return fixed;
    }

    public void setFixed(boolean fixed) {
        this.fixed = fixed;
    }
    
    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }
    
    public void addPermission(Permission p){
        this.permissions.add(p);
    }
}


