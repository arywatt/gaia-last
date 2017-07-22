/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.basedata.dao.impl;

import com.gaia.basedata.dao.IPostDAO;
import com.gaia.basedata.entities.Post;
import com.gaia.entity.dao.impl.DAO;
import org.springframework.stereotype.Repository;

/**
 *
 * @author watt
 */
@Repository("postDAO")
public class PostDAO extends DAO<Post,Integer> implements IPostDAO{

    public PostDAO() {
        super(Post.class);
    }

    
    
}