package com.course.service.user;

import com.course.model.Course;

import java.util.List;

/**
 * Introduction:  [Simple Introduction of the java documents]
 * Package Name:  com.course.service.user
 * Project Name:  course
 * Author:  B丶Y
 * Create Time:  2018/11/14 9:19
 *
 * 课程信息服务接口
 *
 */
public interface CourseService {

    /**
     * 查询全部课程信息
     * @return 课程实体集合
     */
    List<Course> getAllCourse();

    /**
     * 根据课程ID查询课程信息
     * @param courseId 课程ID
     * @return 课程实体
     */
    Course getCourseById(Long courseId);

    /**
     * 根据教师ID 查询课程实体集合
     * @param teacherId 教师ID
     * @return
     */
    List<Course> getCourseByTeacherId(Long teacherId);

}
