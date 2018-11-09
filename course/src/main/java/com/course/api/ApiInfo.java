package com.course.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiInfo {
	private String url;
	private String description;
	private String[] params;
	private String method;
	private String node;
}
