package com.jasonr.community.service.Impl;

import com.jasonr.community.dao.DiscussPostMapper;
import com.jasonr.community.domain.DiscussPost;
import com.jasonr.community.service.DiscussPostService;
;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jasonR
 * @date 2021/3/10 11:54
 */
@Service
public class DiscussPostServiceImpl implements DiscussPostService {

    @Autowired
    private DiscussPostMapper discussPostMapper;

    public List<DiscussPost> findDiscussPosts(int userId,int offset,int limit){
        return discussPostMapper.selectDiscussPost(userId,offset,limit);
    }

    public int findDiscussPostRows(int userId){
        return discussPostMapper.selectDiscussPostRows(userId);
    }
}
