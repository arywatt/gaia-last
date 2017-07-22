/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gaia.entity.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/**
 *
 * @author komilo
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Version
    @Column(nullable=false)
    protected Integer version = 1;

    public BaseEntity() {
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
