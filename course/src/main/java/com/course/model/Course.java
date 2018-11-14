package com.course.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class Course {
    private Long id;

    private String name;

    private String courseType;

    private Date beginTime;

    private Date endTime;

    private String classType;

    private String place;

    private String classroomNo;

    private String teacherName;

    private Long teacherId;
}