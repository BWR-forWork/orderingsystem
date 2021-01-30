package pers.bwr.learn.springcloud.orderingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import pers.bwr.learn.springcloud.orderingsystem.entity.Menu;
import pers.bwr.learn.springcloud.orderingsystem.entity.Order;
import pers.bwr.learn.springcloud.orderingsystem.entity.OrderVO;
import pers.bwr.learn.springcloud.orderingsystem.entity.User;
import pers.bwr.learn.springcloud.orderingsystem.repository.OrderRepository;

import java.util.Date;

@RestController
@RequestMapping("/order")
public class OrderHandler {

    @Value("${server.port}")
    private String port;

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/index")
    public String index() {
        return "order的端口：" + this.port;
    }

    @GetMapping("/findAllByUid/{uid}/{index}/{limit}")
    public OrderVO findAllByUid(@PathVariable("uid") long uid, @PathVariable("index") int index, @PathVariable("limit") int limit) {
        OrderVO orderVO = new OrderVO();
        orderVO.setCode(0);
        orderVO.setMsg("");
        orderVO.setCount(orderRepository.countByUid(uid));
        orderVO.setData(orderRepository.findAllByUid(uid,index,limit));
        return orderVO;
    }

    @GetMapping("/findAllByState/{state}/{index}/{limit}")
    public OrderVO findAllByState(@PathVariable("state") int state, @PathVariable("index") int index, @PathVariable("limit") int limit) {
        OrderVO orderVO = new OrderVO();
        orderVO.setCode(0);
        orderVO.setMsg("");
        orderVO.setCount(orderRepository.countByState(state));
        orderVO.setData(orderRepository.findAllByState(state,index,limit));
        return orderVO;
    }

    @PostMapping("/save")
    public void save(@RequestBody Order order) {
        orderRepository.save(order);
    }

    @GetMapping("/updateState")
    public void updateState(@RequestParam("id") long id, @RequestParam("aid") long aid, @RequestParam("state") int state){
        orderRepository.updateState(id, aid, state);
    }

}

