package com.course.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 消息类，具体使用可以参照{@link MessageHandler}
 */
@Data
@Accessors(chain = true)
public class BaseMessage<T> {
	private boolean success;
	private T data;
	private String message;

}
