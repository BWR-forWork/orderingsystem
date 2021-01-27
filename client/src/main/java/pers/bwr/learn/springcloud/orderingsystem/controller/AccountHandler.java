package pers.bwr.learn.springcloud.orderingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pers.bwr.learn.springcloud.orderingsystem.entity.Account;
import pers.bwr.learn.springcloud.orderingsystem.entity.Admin;
import pers.bwr.learn.springcloud.orderingsystem.entity.User;
import pers.bwr.learn.springcloud.orderingsystem.feign.AccountFeign;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Author 黑色的白兔子
 * @CreateTime: 2021/1/25 上午 11:41
 * @Version: v1.0
 */
@Controller
@RequestMapping("/account")
public class AccountHandler {

    @Autowired
    private AccountFeign accountFeign;

    /**
     * 视图解析
     * @param location
     * @return
     */
    @GetMapping("/redirect/{location}")
    public String redirect(@PathVariable("location") String location) {
        return location;
    }

    @PostMapping("/login")
    public String login(@RequestParam Map<String,Object> account, HttpSession session) {
        if(null==account.get("type")) {
            return "redirect:/account/redirect/login";
        }
        switch (account.get("type").toString()) {
            case "user" :
                User user = accountFeign.userLogin(account);
                session.setAttribute("user",user);
                return "redirect:/account/redirect/index";
            case "admin" :
                Admin admin = accountFeign.adminLogin(account);
                session.setAttribute("admin",admin);
                return "redirect:/account/redirect/main";
            default:
                return "redirect:/account/redirect/login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/account/redirect/login";
    }
}
