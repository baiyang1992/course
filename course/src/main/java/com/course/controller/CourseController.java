package com.course.controller;

import com.course.api.ApiDoc;
import com.course.model.BaseMessage;
import com.course.model.Course;
import com.course.model.MessageHandler;
import com.course.service.user.CourseService;
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
 * Create Time:  2018/11/14 9:29
 *
 * 课程信息服务接口
 *
 */
@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    /**
     * 查询全部用户数据
     * @return 用户数据集合
     */
    @ApiDoc("【用户信息服务】查询全部用户信息")
    @ResponseBody
    @GetMapping("/getallcourse")
    public BaseMessage<?> getAllCourse(){
        List<Course> courseList = courseService.getAllCourse();
        if (!CollectionUtils.isEmpty(courseList)){
            return MessageHandler.createSuccessVo(courseList,"获取全部课程信息成功");
        }else {
            return MessageHandler.createFailedVo("获取全部课程信息失败");
        }
    }

}
