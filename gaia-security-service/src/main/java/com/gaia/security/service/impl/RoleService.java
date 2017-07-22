/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gaia.security.service.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import com.gaia.entity.exception.BusinessException;
import com.gaia.entity.service.impl.CRUDService;
import com.gaia.security.dao.IRoleDAO;
import com.gaia.security.entities.Role;
import com.gaia.security.service.IRoleService;

/**
 *
 * @author komilo
 */
@Service("roleService")
public class RoleService extends CRUDService<Role, Long> implements IRoleService {
    
    @Autowired(required=true)
    public RoleService(IRoleDAO dao) {
        super(dao);
    }
    
    private IRoleDAO getDAO() {
        return (IRoleDAO) this.dao;
    }

    @Override
    public Role getOneByName(String name) {
        try {
            return this.getDAO().getOneByName(name);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }
    
    private void checkRoleNameDuplicate(Role t) {
        try {
            Role role = this.getDAO().getOneByName(t.getName());
            if ((role != null) && (! role.getId().equals(t.getId()))) {
                throw new BusinessException("security", "Un role portant le meme nom existe déjà.");
            }
        } catch (EmptyResultDataAccessException ex) {
        }
    }
    
    private boolean isRoleNameDuplicated(Role t) {
        Role role = this.getDAO().getOneByName(t.getName());
        if ((role != null) && (! role.getId().equals(t.getId()))) {
            return true;
        }
        return false;
    }

    @Override
    public synchronized Role saveOne(Role t) {
        this.checkRoleNameDuplicate(t);
        return super.saveOne(t);
    }

    @Override
    public synchronized Collection<Role> saveRange(Iterator<Role> ts) {
        Collection<Role> ts2 = new LinkedList<Role>();
        while (ts.hasNext()) {
            Role role = ts.next();
            if (this.isRoleNameDuplicated(role)) {
                continue;
            }
            ts2.add(this.dao.saveOne(role));
        }
        return ts2;
    }

    @Override
    public synchronized Role updateOne(Role t) {
        this.checkRoleNameDuplicate(t);
        return super.updateOne(t);
    }

    @Override
    public synchronized Collection<Role> updateRange(Iterator<Role> ts) {
        Collection<Role> ts2 = new LinkedList<Role>();
        while (ts.hasNext()) {
            Role role = ts.next();
            if (this.isRoleNameDuplicated(role)) {
                continue;
            }
            ts2.add(this.dao.updateOne(role));
        }
        return ts2;
    }
}
