package pers.bwr.learn.springcloud.orderingsystem.repository;

import org.springframework.stereotype.Repository;
import pers.bwr.learn.springcloud.orderingsystem.entity.Order;

import java.util.Date;
import java.util.List;

/**
 * @Author 黑色的白兔子
 * @CreateTime: 2021/1/27 下午 2:12
 * @Version: v1.0
 */
@Repository
public interface OrderRepository {
    public int countByUid(long uid);
    public List<Order> findAllByUid(long uid,int index, int limit);
    public int countByState(int state);
    public List<Order> findAllByState(int state, int index, int limit);
    public void save(Order order);
    public void updateState(long id, long aid, int state);
}
