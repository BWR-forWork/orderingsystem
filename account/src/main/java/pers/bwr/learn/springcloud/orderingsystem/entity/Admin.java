package pers.bwr.learn.springcloud.orderingsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author 黑色的白兔子
 * @CreateTime: 2021/1/25 下午 2:12
 * @Version: v1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin extends Account{
    private long id;
}
