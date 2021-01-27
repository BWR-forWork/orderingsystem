package pers.bwr.learn.springcloud.orderingsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author 黑色的白兔子
 * @CreateTime: 2021/1/25 上午 11:49
 * @Version: v1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private String username;
    private String password;
    private String type;
}
