package pers.bwr.learn.springcloud.orderingsystem.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import pers.bwr.learn.springcloud.orderingsystem.entity.Order;
import pers.bwr.learn.springcloud.orderingsystem.entity.OrderVO;

/**
 * @Author 黑色的白兔子
 * @CreateTime: 2021/1/27 下午 1:48
 * @Version: v1.0
 */
@FeignClient(value="order")
public interface OrderFeign {

    @GetMapping("/order/findAllByUid/{uid}/{index}/{limit}")
    public OrderVO findAllByUid(
            @PathVariable("uid") long uid,
            @PathVariable("index") int index,
            @PathVariable("limit") int limit);

    @GetMapping("/order/findAllByState/{state}/{index}/{limit}")
    public OrderVO findAllByState(
            @PathVariable("state") int state,
            @PathVariable("index") int index,
            @PathVariable("limit") int limit);

    @PostMapping("/order/save")
    public void save(@RequestBody Order order);

}
