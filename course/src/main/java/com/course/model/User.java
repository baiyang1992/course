package com.course.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class User {
    private Integer id;

    private String name;

    private String sex;

    private String phoneNo;

    private String level;

    private String type;

}