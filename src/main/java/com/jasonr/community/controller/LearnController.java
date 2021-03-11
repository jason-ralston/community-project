package com.jasonr.community.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jasonr.community.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jasonR
 * @date 2021/3/9 20:33
 */

@Controller
@RequestMapping("/learn")
public class LearnController {
    @RequestMapping("/http")
    public void http(HttpServletRequest request, HttpServletResponse response){
        //获取请求数据
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());

        //返回响应数据
        response.setContentType("text/html;charset=utf-8");
        try(PrintWriter writer =response.getWriter()) {
            writer.write("<h1>社区论坛</h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //GET请求

    // /student?cunrrent=1&limit=20
    @RequestMapping(path="/student",method = RequestMethod.GET)
    @ResponseBody
    public String getStudents(@RequestParam(name = "current",required = false,defaultValue = "1") int current,
                              @RequestParam(name="limit",required = false,defaultValue = "10") int limit){
        return "some students";

    }

    // /student/123
    @RequestMapping(path="/student/{id}",method = RequestMethod.GET)
    @ResponseBody
    public String getStudent(@PathVariable("id") int id){
        System.out.println(id);
        return "a student";
    }

    //POST请求
    @RequestMapping(path="/student",method = RequestMethod.POST)
    @ResponseBody
    public String saveStudent(int name,int age){
        System.out.println(name);
        System.out.println(age);
        return "success";
    }

    // 响应hTML数据
    @RequestMapping(path="/teacher",method = RequestMethod.GET)
    public ModelAndView getTeacher(){
        ModelAndView mav=new ModelAndView();
        mav.addObject("name","张三");
        mav.addObject("age",30);
        mav.setViewName("demo/view");
        return mav;
    }

    @RequestMapping(path="/school",method = RequestMethod.GET)
    public  String getSchool(Model model){
        model.addAttribute("name","张三");
        model.addAttribute("age",30);
        return "/demo/view";
    }

    //响应JSON数据(异步请求中，或者是前后端分离中)
    // Java对象 -> JSON -> JS对象

    @RequestMapping(path = "/emp",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getEmp(){
        Map<String,Object> emp=new HashMap<>();
        emp.put("name","张三");
        return emp;
    }

    //返回对象，需要使用jackson jar包,springboot自己带了
    //记得在实体类里面加getter和setter
    @RequestMapping(path = "/delete",method = RequestMethod.GET)
    @ResponseBody
    public User delete(){
        return new User();
    }



}
