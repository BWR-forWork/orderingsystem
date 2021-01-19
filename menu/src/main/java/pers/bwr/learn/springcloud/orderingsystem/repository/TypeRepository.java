package pers.bwr.learn.springcloud.orderingsystem.repository;

import pers.bwr.learn.springcloud.orderingsystem.entity.Type;

import java.util.List;

/**
 * @Author 黑色的白兔子
 * @CreateTime: 2021/1/19 下午 11:41
 * @Version: v1.0
 */
public interface TypeRepository {
    public List<Type> findAll();
    public Type findById();
}
