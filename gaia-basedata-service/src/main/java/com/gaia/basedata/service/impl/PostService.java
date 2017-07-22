/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.basedata.service.impl;

import com.gaia.basedata.dao.IPostDAO;
import com.gaia.basedata.entities.Post;
import com.gaia.basedata.service.IPostService;
import com.gaia.entity.service.impl.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author watt
 */
@Repository("postService")
public class PostService extends CRUDService<Post,Integer> implements IPostService{
    
    @Autowired(required=true)
    public PostService(IPostDAO dao) {
        super(dao);
    }
}
