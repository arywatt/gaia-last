/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.basedata.entities;

import com.gaia.entity.entities.BaseEntity;
import com.gaia.security.entities.User;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author watt
 */

@Entity
@Table(name="notifications")
public class Notification extends BaseEntity{
    
    private static final long serialVersionUID = 1L;
    
     
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(unique = true,name = "title",length = 50,nullable = false)
    private String title;
    
//    
//    @Column(unique = true,name = "source",length = 50,nullable = true)
//    @OneToOne
//    private User fromUser;
//    
//    
//    @Column(unique = true,name = "destination",length = 50,nullable = true)
//    @OneToOne
//    private User toUser;
    
//    @Column(unique = true,name = "post_related",length = 50,nullable = true)
//    private Post relatedPost;
    
    
    
    
    
    
}
