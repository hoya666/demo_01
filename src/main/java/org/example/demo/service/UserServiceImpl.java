package org.example.demo.service;

import jdk.nashorn.internal.ir.CallNode;
import org.example.demo.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UserServiceImpl implements UserService {
    private static AtomicLong counterId = new AtomicLong();
    private final ConcurrentMap<Long, User> userConcurrentMap = new ConcurrentHashMap<Long, User>();

    @Override
    public User addUser(User user) {
        Long id = user.getId();
        if(id==null){
            id = counterId.incrementAndGet();
            user.setId(id);
        } else{
            System.out.println("id chongfu");
        }
        this.userConcurrentMap.put(id,user);
        return user;
    }

    @Override
    public boolean deleteUserById(Long id) {
        if(this.userConcurrentMap.get(id)!=null){
            System.out.println(userConcurrentMap.get(id));
            System.out.println(this.userConcurrentMap.get(id));
            this.userConcurrentMap.remove(id);
        } else{
            System.out.println("false");
            return false;
        }
        return true;
    }

    @Override
    public boolean updateUser(User user) {
        Long id = user.getId();
        if(this.userConcurrentMap.get(id)!=null){
            this.userConcurrentMap.replace(id,user);
        } else{
            return false;
        }
        return true;
    }

    @Override
    public User getUserById(Long id) {
        if(this.userConcurrentMap.get(id)!=null){
            return this.userConcurrentMap.get(id);
        } else{
            return null;
        }
    }

    @Override
    public List<User> getUserList() {
        return new ArrayList<User>(this.userConcurrentMap.values());
    }
}
