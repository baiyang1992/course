package com.course.controller;

import com.course.api.ApiDoc;
import com.course.model.BaseMessage;
import com.course.model.MessageHandler;
import com.course.model.User;
import com.course.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Introduction:  [Simple Introduction of the java documents]
 * Package Name:  com.course.controller
 * Project Name:  course
 * Author:  B丶Y
 * Create Time:  2018/11/7 11:27
 *
 * 用户信息controller
 * 我改一下试试
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询全部用户数据
     * @return 用户数据集合
     */
    @ApiDoc("【用户信息服务】查询全部用户信息")
    @ResponseBody
    @GetMapping("/getusers")
    public BaseMessage<?> getUsers(){
        List<User> userList = userService.getUsers();
        if (!CollectionUtils.isEmpty(userList)){
            return MessageHandler.createSuccessVo(userList,"获取全部用户信息成功");
        }else {
            return MessageHandler.createFailedVo("获取全部用户信息失败");
        }
    }

    /**
     * 根据主键ID 查询用户信息
     * @return 用户实体信息
     */
    @ApiDoc("【用户信息服务】根据主键ID查询用户实体信息")
    @ResponseBody
    @GetMapping("/getuserbyId")
    public BaseMessage<?> getUserById(Integer id){
        User user = userService.getUserById(id);
        if (null != user){
            return MessageHandler.createSuccessVo(user,"根据主键查询用户信息成功");
        }else {
            return MessageHandler.createFailedVo("根据主键查询用户信息失败");
        }
    }

}
