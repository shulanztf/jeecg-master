package com.ztf.backend.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ztf.backend.model.ZxbMoneyInRecModel;

/**
 * 
 * @Title: FullBashService
 * @Description:
 * @Author: zhaotf
 * @Since:2017年7月14日 下午2:17:25
 * @Version:1.0
 */
public interface FullBashService {

	/**
	 * 导出
	 * 
	 * @param request
	 * @return List<ZxbMoneyInRecModel>
	 */
	public List<ZxbMoneyInRecModel> findMoneyInRecList(HttpServletRequest request);

}
