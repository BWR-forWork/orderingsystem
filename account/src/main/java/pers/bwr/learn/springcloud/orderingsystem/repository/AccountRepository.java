package pers.bwr.learn.springcloud.orderingsystem.repository;

import org.springframework.stereotype.Repository;
import pers.bwr.learn.springcloud.orderingsystem.entity.Account;
import pers.bwr.learn.springcloud.orderingsystem.entity.Admin;
import pers.bwr.learn.springcloud.orderingsystem.entity.User;

/**
 * @Author 黑色的白兔子
 * @CreateTime: 2021/1/25 下午 2:11
 * @Version: v1.0
 */
@Repository
public interface AccountRepository {
    public User userLogin(User user);
    public Admin adminLogin(Admin admin);
}
