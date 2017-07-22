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
import javax.persistence.OneToOne;
import javax.persistence.Table;
//import org.hibernate.annotations.Cache;
//import org.hibernate.annotations.CacheConcurrencyStrategy;
//import org.hibernate.annotations.Index;
//import org.eclipse.persistence.annotations.Index;
import com.gaia.entity.entities.BaseEntity;
import java.util.Objects;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * Simple class that represents any User domain entity in any application.
 *
 * <p>Because this class performs its own Realm and Permission checks, and these can happen frequently enough in a
 * production application, it is highly recommended that the internal User {@link #getRoles} collection be cached
 * in a 2nd-level cache when using JPA and/or Hibernate.  The hibernate xml configuration for this sample application
 * does in fact do this for your reference (see User.hbm.xml - the 'roles' declaration).</p>
 */
@Entity
@Table(name="users")
//@Cache(usage= CacheConcurrencyStrategy.READ_WRITE)
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Basic(optional=false)
    @Column(length=100, unique=true)
//    @Index(name="idx_users_username")
    private String username;
    
    @Basic(optional=false)
    @Column(length=255)
    private String password;

    @Basic(optional=false)
    @Column(nullable=false)
    private boolean enabled;
    
    @OneToOne(mappedBy = "user", fetch=FetchType.LAZY)
    private UserDetails userDetails;
    
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="users_roles", joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id"))
    
//    @Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
    private Set<Role> roles = new HashSet<>();

    public User() {
        this.enabled = true;
    }

    public User(String username, String password, boolean enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    public String getUsernameString() {
        if (this.userDetails != null) {
            return this.userDetails.getFullName();
        }
        return this.username;
    }

    public String getRolesString() {
        StringBuilder builfer = new StringBuilder("");
        int i = 1, n = roles.size();
        for (Role role : roles) {
            builfer.append(role.getName());
            if (i != n) {
                builfer.append(", ");
            }
            i++;
        }
        return builfer.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        return !(!Objects.equals(this.id, other.id) && (this.id == null || !this.id.equals(other.id)));
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + "username=" + username + "password=" + password + "enabled=" + enabled + '}';
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }
}


