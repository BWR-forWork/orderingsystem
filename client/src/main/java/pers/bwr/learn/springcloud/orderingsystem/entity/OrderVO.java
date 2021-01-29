package pers.bwr.learn.springcloud.orderingsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author 黑色的白兔子
 * @CreateTime: 2021/1/27 下午 1:38
 * @Version: v1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderVO {
    private int code;
    private String msg;
    private int count;
    private List<Order> data;
}
