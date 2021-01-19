package pers.bwr.learn.springcloud.orderingsystem.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pers.bwr.learn.springcloud.orderingsystem.entity.MenuVO;

@FeignClient(value="menu")
public interface MenuFeign {

    @GetMapping("/menu/findAll/{index}/{limit}")
    public MenuVO findAll(@PathVariable("index") int index, @PathVariable("limit") int limit);
}
