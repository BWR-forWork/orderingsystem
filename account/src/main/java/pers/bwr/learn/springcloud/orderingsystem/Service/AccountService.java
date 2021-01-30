package pers.bwr.learn.springcloud.orderingsystem.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.bwr.learn.springcloud.orderingsystem.entity.Account;
import pers.bwr.learn.springcloud.orderingsystem.entity.Admin;
import pers.bwr.learn.springcloud.orderingsystem.entity.User;
import pers.bwr.learn.springcloud.orderingsystem.repository.AccountRepository;

/**
 * @Author 黑色的白兔子
 * @CreateTime: 2021/1/25 下午 1:29
 * @Version: v1.0
 */
@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public User login(User user) {
        return accountRepository.userLogin(user);
    }

    public Admin login(Admin admin) {
        int i = 1;
        Admin getted = accountRepository.adminLogin(admin);
        return getted;
    }
}
