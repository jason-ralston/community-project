package com.jasonr.community.controller;


import com.jasonr.community.domain.DiscussPost;
import com.jasonr.community.domain.Page;
import com.jasonr.community.domain.User;
import com.jasonr.community.service.DiscussPostService;
import com.jasonr.community.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jasonR
 * @date 2021/3/10 12:02
 */
@Slf4j(topic = "HomeController")
@Controller
public class HomeController {

    @Autowired
    private DiscussPostService discussPostService;

    @Autowired
    private UserService userService;

    //使用前后端分离来重构代码的话，需要将page和显示的页面集合传递到前端
    @RequestMapping(path="/index",method = RequestMethod.GET)
    public String getIndexPage(Model model, Page page){
        //方法调用前，soringmvc会自动实例化model和page，并将page注入model
        //所以，在thymeleaf中可以直接访问page对象中的数据
        page.setRows(discussPostService.findDiscussPostRows(0));
        page.setPath("/index");

        List<DiscussPost> list=discussPostService.findDiscussPosts(0,page.getOffset(),page.getLimit());
        List<Map<String,Object>> discussPosts=new ArrayList<>();
        //这个集合里面存储的是用户和帖子的对应关系
        if(list !=null){
            for (DiscussPost post : list) {
                Map<String,Object> map=new HashMap<>();
                map.put("post",post);
                User user= userService.findUserById(post.getUserId());
                map.put("user",user);
                discussPosts.add(map);
            }
        }

        model.addAttribute("discussPosts",discussPosts);
        return "/index";
    }

}
