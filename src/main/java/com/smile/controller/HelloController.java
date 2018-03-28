package com.smile.controller;

import com.smile.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * Created by yaojiulong on 2017/7/12.
 */
@Controller
@RequestMapping("/hello")
public class  HelloController {

    @Autowired
    private GirlProperties girl;

    @RequestMapping(value = "/say/{id}", method = RequestMethod.GET)
    public String say(@PathVariable("id") Integer id){
       // System.out.println("size  "+22);

        return "id : "+id;
    }

    @PostMapping("/say/post")
    public String sayPost(HttpServletRequest httpServletRequest){
        String id = httpServletRequest.getParameter("id");
        return "Post请求 "+id;
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(HashMap<String, Object> map){
        System.out.println("访问了");
        map.put("hello","11111");
        return "/index";
    }


    @RequestMapping(value = "/json", method = RequestMethod.POST)
    @ResponseBody
    public String getJson(@RequestBody String s){

        return s;
    }


}
