package pers.bwr.learn.springcloud.orderingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import pers.bwr.learn.springcloud.orderingsystem.entity.User;
import pers.bwr.learn.springcloud.orderingsystem.entity.UserVO;
import pers.bwr.learn.springcloud.orderingsystem.repository.UserRepository;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserHandler {

    @Value("${server.port}")
    private String port;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/index")
    public String index() {
        return this.port;
    }

    @GetMapping("/findAll/{index}/{limit}")
    public UserVO findAll(@PathVariable("index") int index, @PathVariable("limit") int limit) {
        UserVO userVO = new UserVO();
        userVO.setCode(0);
        userVO.setMsg("");
        userVO.setCount(userRepository.count());
        userVO.setData(userRepository.findAll(index,limit));
        return userVO;
    }

    @PostMapping("/save")
    public void save(@RequestBody User user){
        user.setRegisterdate(new Date());
        userRepository.save(user);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id){
        userRepository.deleteById(id);
    }

    @GetMapping("/findById/{id}")
    public User findById(@PathVariable("id") long id){
        return userRepository.findById(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody User user) {
        userRepository.update(user);
    }
}
