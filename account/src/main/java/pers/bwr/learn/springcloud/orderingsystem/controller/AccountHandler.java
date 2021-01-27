package pers.bwr.learn.springcloud.orderingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.bwr.learn.springcloud.orderingsystem.Service.AccountService;
import pers.bwr.learn.springcloud.orderingsystem.entity.Account;
import pers.bwr.learn.springcloud.orderingsystem.entity.Admin;
import pers.bwr.learn.springcloud.orderingsystem.entity.User;

/**
 * @Author 黑色的白兔子
 * @CreateTime: 2021/1/25 下午 12:25
 * @Version: v1.0
 */
@RestController
@RequestMapping("/account")
public class AccountHandler {

    @Autowired
    private AccountService accountService;

    @PostMapping("/login")
    public Account login(@RequestBody Account account) {
        if(account == null) {
            return null;
        }
        switch(account.getType()) {
            case "user":
                //check user
                User user = new User();
                user.setUsername(account.getUsername());
                user.setPassword(account.getPassword());
                return (Account)accountService.login(user);
            case "admin":
                //check admin
                Admin admin = new Admin();
                admin.setUsername(account.getUsername());
                admin.setPassword(account.getPassword());
                return (Account)accountService.login(admin);
            default:
                return null;
        }
    }

    @PostMapping("/userlogin")
    public User userLogin(@RequestBody Account account) {
        User user = new User();
        user.setUsername(account.getUsername());
        user.setPassword(account.getPassword());
        return accountService.login(user);
    }

    @PostMapping("/adminlogin")
    public Admin adminLogin(@RequestBody Account account) {
        Admin admin = new Admin();
        admin.setUsername(account.getUsername());
        admin.setPassword(account.getPassword());
        return accountService.login(admin);
    }
}
