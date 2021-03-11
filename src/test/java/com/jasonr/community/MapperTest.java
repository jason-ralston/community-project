package com.jasonr.community;

import com.jasonr.community.dao.DiscussPostMapper;
import com.jasonr.community.dao.UserMapper;
import com.jasonr.community.domain.DiscussPost;
import com.jasonr.community.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

/**
 * @author jasonR
 * @date 2021/3/10 11:02
 */

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTest {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Test
    public void  TestSelectUser(){
        User user=userMapper.selectById(101);
        System.out.println(user);
    }

    @Test
    public void testSelectPost(){
        List<DiscussPost> list =discussPostMapper.selectDiscussPost(0,0,10);
        for (DiscussPost discussPost : list) {
            System.out.println(discussPost);
        }
        int rows=discussPostMapper.selectDiscussPostRows(0);
        System.out.println(rows);
    }
}
