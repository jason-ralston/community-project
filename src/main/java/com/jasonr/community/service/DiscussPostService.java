package com.jasonr.community.service;

import com.jasonr.community.domain.DiscussPost;

import java.util.List;

/**
 * @author jasonR
 * @date 2021/3/10 12:04
 */
public interface DiscussPostService {

    public List<DiscussPost> findDiscussPosts(int userId, int offset, int limit);

    public int findDiscussPostRows(int userId);
}
