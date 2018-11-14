package com.course.dao;

import com.course.model.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseDao {
    int deleteByPrimaryKey(Long id);

    int insert(Course record);

    Course selectByPrimaryKey(Long id);

    List<Course> selectAll();

    int updateByPrimaryKey(Course record);

    List<Course> getCourseByTeacherId(Long teacherId);
}