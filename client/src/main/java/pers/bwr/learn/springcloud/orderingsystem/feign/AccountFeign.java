package pers.bwr.learn.springcloud.orderingsystem.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pers.bwr.learn.springcloud.orderingsystem.entity.Account;
import pers.bwr.learn.springcloud.orderingsystem.entity.Admin;
import pers.bwr.learn.springcloud.orderingsystem.entity.User;

import java.util.Map;

/**
 * @Author 黑色的白兔子
 * @CreateTime: 2021/1/25 下午 12:08
 * @Version: v1.0
 */
@FeignClient(value = "account")
public interface AccountFeign {

    @PostMapping("/account/userlogin")
    public User userLogin(@RequestBody Map account);
    @PostMapping("/account/adminlogin")
    public Admin adminLogin(@RequestBody Map account);
}
