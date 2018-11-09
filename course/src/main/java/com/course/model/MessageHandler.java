package com.course.model;

import org.springframework.data.domain.Page;

/**
 * 生成消息
 */
public class MessageHandler {
	/**
	 * 创建一个请求失败的消息类
	 */
	public static BaseMessage<String> createFailedVo(String msg) {
		BaseMessage<String> base = new BaseMessage<String>();
		base.setData(null);
		base.setSuccess(false);
		base.setMessage(msg);
		return base;
	}
	/**
	 * 创建一个请求失败的消息类，data存储错误码
	 */
	public static BaseMessage<String> createFailedCodeVo(String data,String msg) {
		BaseMessage<String> base = new BaseMessage<String>();
		base.setData(data);
		base.setSuccess(false);
		base.setMessage(msg);
		return base;
	}
	/**
	 * 创建一个请求成功的消息类
	 */
	public static BaseMessage<String> createSuccessVo(String msg) {
		BaseMessage<String> base = new BaseMessage<String>();
		base.setData(null);
		base.setSuccess(true);
		base.setMessage(msg);
		return base;
	}

	/**
	 * 创建一个请求成功的带数据的消息类
	 */
	public static <T> BaseMessage<T> createSuccessVo(T t, String msg) {
		BaseMessage<T> base = new BaseMessage<T>();
		base.setData(t);
		base.setSuccess(true);
		base.setMessage(msg);
		return base;
	}

	public static <T> EasyUiDataGridData createSuccessVo(Page<T> t, String msg) {
		EasyUiDataGridData data = new EasyUiDataGridData();
		if (t != null) {
			data.setTotal(t.getTotalElements());
			data.setRows(t.getContent());
		}
		data.setSuccess(true);
		data.setMessage(msg);
		return data;

	}
}
