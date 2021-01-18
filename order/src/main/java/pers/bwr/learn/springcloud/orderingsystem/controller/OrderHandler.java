package pers.bwr.learn.springcloud.orderingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderHandler {

    @Value("${server.port}")
    private String port;

    @GetMapping("/index")
    public String index() {
        return "order的端口：" + this.port;
    }

}

