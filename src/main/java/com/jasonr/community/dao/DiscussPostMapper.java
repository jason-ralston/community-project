package com.jasonr.community.dao;

import com.jasonr.community.domain.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jasonR
 * @date 2021/3/10 11:25
 */
@Mapper
@Repository
public interface DiscussPostMapper {

    List<DiscussPost> selectDiscussPost(int userId,int offset,int limit);
    //这里对userid的使用有讲究
    //如果仅仅只是显示首页的帖子，那么我们不将这个id拼接到sql中作为语句去查询
    //如果要显示某一用户创建的帖子，那么拼接到sql中去查询

    //@Param注解用于给参数取别名
    //如果只有一个参数，并且在<if>中使用，那么必须加别名
    int selectDiscussPostRows(@Param("userId") int userId);
    //查询所有帖子数量

}
