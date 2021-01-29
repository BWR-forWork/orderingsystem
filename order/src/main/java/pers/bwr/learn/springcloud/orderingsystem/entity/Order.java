package pers.bwr.learn.springcloud.orderingsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.util.Date;

/**
 * @Author 黑色的白兔子
 * @CreateTime: 2021/1/27 下午 1:43
 * @Version: v1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private long id;
    private User user;
    private Menu menu;
    private Admin admin;
    private Date date;
    private int state;
}
