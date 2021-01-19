package pers.bwr.learn.springcloud.orderingsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author 黑色的白兔子
 * @CreateTime: 2021/1/19 下午 7:00
 * @Version: v1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuVO {
    private int code;
    private String msg;
    private int count;
    private List<Menu> data;
}
