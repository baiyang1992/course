package com.course.service.user;

import com.course.model.User;

import java.util.List;

/**
 * Introduction:  [Simple Introduction of the java documents]
 * Package Name:  com.course.service.user
 * Project Name:  course
 * Author:  B丶Y
 * Create Time:  2018/11/8 16:40
 *
 * 用户操作接口
 *
 */
public interface UserService {

    /**
     * 获取全部用户信息
     * @return 用户实体信息集合
     */
    List<User> getUsers();

    /**
     * 根据用户ID查询用户信息
     * @param id 用户ID
     * @return 用户实体信息
     */
    User getUserById(Integer id);

}
