package pers.bwr.learn.springcloud.orderingsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author 黑色的白兔子
 * @CreateTime: 2021/1/25 下午 12:19
 * @Version: v1.0
 */
@SpringBootApplication
@MapperScan("pers.bwr.learn.springcloud.orderingsystem.repository")
public class accountApplication {
    public static void main(String[] args) {
        SpringApplication.run(accountApplication.class,args);
    }
}
