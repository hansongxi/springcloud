package com.atguigu.crowdfunding.common.controller;

import java.util.HashMap;
import java.util.Map;

public class BaseResultController {
	private ThreadLocal<Map<String,Object>>  datas= 
			new ThreadLocal<Map<String,Object>>();
	/**
	 * 用来获取datas的对象
	 */
	protected void start() {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		datas.set(resultMap);
	}
	/**
	 * 用来返回对象
	 */
	protected Object end() {
		Map<String, Object> resultMap = datas.get();
		//先得到data的对象，再移除全部的，保证在存取一个之后ThreadLocal无数据，方便下次的存取
		datas.remove();
		return resultMap;
	}
	/**
	 * 存取成功或者失败的状态
	 */
	protected void success(boolean flag) {
		Map<String, Object> map = datas.get();
		map.put("success", flag);
	} 
	/**
	 * 存取数据
	 * 
	 */
	protected void param(String key,Object val) {
		Map<String, Object> map = datas.get();
		map.put(key,val);
	}
	/**
	 * 存取信息
	 */
	protected void message(String msg) {
		Map<String, Object> map = datas.get();
		map.put("message",msg);
	}
	
}
