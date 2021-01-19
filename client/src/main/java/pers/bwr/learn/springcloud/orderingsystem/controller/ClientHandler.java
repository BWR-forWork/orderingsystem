package pers.bwr.learn.springcloud.orderingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pers.bwr.learn.springcloud.orderingsystem.entity.MenuVO;
import pers.bwr.learn.springcloud.orderingsystem.feign.MenuFeign;

@Controller
@RequestMapping("/client")
public class ClientHandler {

    @Autowired
    private MenuFeign menuFeign;

    @GetMapping("/findAll")
    @ResponseBody
    public MenuVO findAll(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        int index = (page-1)*limit;
        return menuFeign.findAll(index, limit);
    }

    @GetMapping("/redirect/{location}")
    public String redirect(@PathVariable("location") String location) {
        return location;
    }
}
