/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.basedata.entities;

import com.gaia.entity.entities.BaseEntity;
import com.gaia.security.entities.User;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author watt
 */

@Entity
@Table(name="comments")
public class Comment extends BaseEntity{
    
     private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(name = "content",length = 150,nullable = true)
    private String content;
        
    
    @Column(name = "owner",length = 150,nullable = true)
    private User owner;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "related_post",nullable = false)
    private Post relatedPost;
        
    @Column(name = "comment_date")
    private Date comentDate;
   
    
}
