package com.course.service.impl;

import com.course.dao.CourseDao;
import com.course.model.Course;
import com.course.service.user.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Introduction:  [Simple Introduction of the java documents]
 * Package Name:  com.course.service.impl
 * Project Name:  course
 * Author:  B丶Y
 * Create Time:  2018/11/14 9:26
 */
@Service("courseserviceimpl")
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseDao courseDao;

    /**
     * 查询全部课程信息
     * @return 课程实体集合
     */
    @Override
    public List<Course> getAllCourse() {
        return courseDao.selectAll();
    }

    /**
     * 根据课程ID查询课程信息
     * @param courseId 课程ID
     * @return 课程实体
     */
    @Override
    public Course getCourseById(Long courseId) {
        return courseDao.selectByPrimaryKey(courseId);
    }

    /**
     * 根据教师ID 查询课程实体集合
     * @param teacherId 教师ID
     * @return
     */
    @Override
    public List<Course> getCourseByTeacherId(Long teacherId) {
        return null;
    }
}
