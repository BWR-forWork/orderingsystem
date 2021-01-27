package pers.bwr.learn.springcloud.orderingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pers.bwr.learn.springcloud.orderingsystem.entity.User;
import pers.bwr.learn.springcloud.orderingsystem.feign.UserFeign;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserHandler {

    @Autowired
    private UserFeign userFeign;
    //@Autowired
    //private OrderFeign orderFeign;


    @GetMapping("/findAll/{page}/{limit}")
    @ResponseBody
    public List<User> findAll(@RequestParam("page") int page, @RequestParam("limit") int limit){
        return userFeign.findAll(page*(limit-1), limit);
    }

    @PostMapping("/save")
    public String save(User user){
        userFeign.save(user);
        return "redirect:/user/redirect/user_manage";
    }

    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") long id){
        //orderFeign.deleteByUid(id);
        userFeign.deleteById(id);
        return "redirect:/user/redirect/user_manage";
    }
}

