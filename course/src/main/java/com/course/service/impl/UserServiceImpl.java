package com.course.service.impl;

import com.course.dao.UserDao;
import com.course.model.User;
import com.course.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Introduction:  [Simple Introduction of the java documents]
 * Package Name:  com.course.service.impl
 * Project Name:  course
 * Author:  B丶Y
 * Create Time:  2018/11/8 16:45
 *
 * 用户信息服务类
 *
 */
@Service(value = "userserviceimpl")
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    /**
     * 获取全部用户信息
     * @return 用户实体信息集合
     */
    @Override
    public List<User> getUsers() {
        return userDao.selectAll();
    }

    /**
     * 根据用户ID查询用户信息
     * @param id 用户ID
     * @return 用户实体信息
     */
    @Override
    public User getUserById(Integer id) {
        return userDao.selectByPrimaryKey(id);
    }


}
