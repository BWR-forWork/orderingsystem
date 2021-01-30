package pers.bwr.learn.springcloud.orderingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pers.bwr.learn.springcloud.orderingsystem.entity.Admin;
import pers.bwr.learn.springcloud.orderingsystem.entity.Menu;
import pers.bwr.learn.springcloud.orderingsystem.entity.Order;
import pers.bwr.learn.springcloud.orderingsystem.entity.OrderVO;
import pers.bwr.learn.springcloud.orderingsystem.entity.User;
import pers.bwr.learn.springcloud.orderingsystem.feign.OrderFeign;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @Author 黑色的白兔子
 * @CreateTime: 2021/1/27 下午 1:33
 * @Version: v1.0
 */
@Controller
@RequestMapping("/order")
public class OrderHandler {

    @Autowired
    OrderFeign orderFeign;

    @GetMapping("/redirect/{location}")
    public String redirect(@PathVariable("location") String location) {
        return location;
    }

    @GetMapping("/findAllByUid")
    @ResponseBody
    public OrderVO findAllByUid(@RequestParam("page") int page, @RequestParam("limit") int limit, HttpSession session) {
        OrderVO orderVO = orderFeign.findAllByUid(((User)session.getAttribute("user")).getId(),(page-1)*limit,limit);
        return orderVO;
    }

    @GetMapping("/findAllByState")
    @ResponseBody
    public OrderVO findAllByState(@RequestParam("page") int page, @RequestParam("limit") int limit, HttpSession session) {
        OrderVO orderVO = orderFeign.findAllByState(0,(page-1)*limit,limit);
        return orderVO;
    }

    @GetMapping("/save/{mid}")
    public String save(@PathVariable("mid") long mid, HttpSession session) {
        Order order = new Order();
        User user = (User)session.getAttribute("user");
        Menu menu = new Menu();
        menu.setId(mid);
        order.setUser(user);
        order.setMenu(menu);
        order.setDate(new Date());
        order.setState(1);
        orderFeign.save(order);
        return "redirect:/order/redirect/order";
    }

    @GetMapping("/updateState/{id}/{state}")
    public String updateState(@PathVariable("id") long id, @PathVariable("state") int state, HttpSession session) {
        int i = 0;
        orderFeign.updateState(id, ((Admin)session.getAttribute("admin")).getId(), state);
        System.out.println(session.getAttribute("admin").toString());
        return "redirect:/order/redirect/order_handler";
    }

}
