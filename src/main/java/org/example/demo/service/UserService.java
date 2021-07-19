package org.example.demo.service;

import org.example.demo.pojo.User;

import java.util.List;

public interface UserService {
    // 增 新增用户，返回用户信息 return user
    User addUser(User user);
    // 删 通过id删除用户，返回成功或不成功 return bool
    boolean deleteUserById(Long id);
    // 改 有点麻烦
    boolean updateUser(User user);
    // 查 查一条/全查
    User getUserById(Long id);
    List<User> getUserList();
}
