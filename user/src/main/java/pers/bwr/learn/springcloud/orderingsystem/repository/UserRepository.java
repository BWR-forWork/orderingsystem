package pers.bwr.learn.springcloud.orderingsystem.repository;

import org.springframework.stereotype.Repository;
import pers.bwr.learn.springcloud.orderingsystem.entity.User;

import java.util.List;

@Repository
public interface UserRepository {
    public List<User> findAll(int index, int limit);
    public int count();
    public void save(User user);
    public void deleteById(long id);
    public User findById(long id);
    public void update(User user);
}

