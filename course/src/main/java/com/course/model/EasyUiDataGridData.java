package com.course.model;

import lombok.Data;

@Data
public class EasyUiDataGridData extends BaseMessage<Object> {
	private Long total;
	private Object rows;
	
	
}
