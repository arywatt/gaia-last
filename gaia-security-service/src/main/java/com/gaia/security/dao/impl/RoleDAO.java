/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gaia.security.dao.impl;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import com.gaia.entity.dao.impl.DAO;
import com.gaia.security.dao.IRoleDAO;
import com.gaia.security.entities.Permission;
import com.gaia.security.entities.Role;

/**
 *
 * @author komilo
 */
@Repository("roleDAO")
public class RoleDAO extends DAO<Role, Long> implements IRoleDAO {
    
    public RoleDAO() {
        super(Role.class);
    }

    @Override
    public Role saveOne(Role t) {
        Set<Permission> permissions = new HashSet<Permission>();
        for (Permission permission : t.getPermissions()) {
            permissions.add(this.em.merge(permission));
        }
        t.setPermissions(permissions);
        return super.saveOne(t);
    }

    @Override
    public Role getOneByName(String name) {
        Query query = em.createQuery("SELECT r FROM Role r WHERE r.name = :name");
        query.setParameter("name", name);        
        return (Role) query.getSingleResult();
    }

}
