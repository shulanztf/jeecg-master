package com.ztf.backend.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ztf.backend.model.ZxbMoneyInRecModel;
import com.ztf.backend.service.FullBashService;

/**
 * 
 * @Title: FullBashServiceImpl
 * @Description:
 * @Author: zhaotf
 * @Since:2017年7月14日 下午2:17:51
 * @Version:1.0
 */
@Service("fullBashService")
@Transactional
public class FullBashServiceImpl implements FullBashService {

	@Override
	public List<ZxbMoneyInRecModel> findMoneyInRecList(HttpServletRequest request) {
		List<ZxbMoneyInRecModel> list = new ArrayList<ZxbMoneyInRecModel>();
		ZxbMoneyInRecModel model1 = new ZxbMoneyInRecModel();
		model1.setAssetid("111111111111111111");
		model1.setBankcardnum("65846234188");
		model1.setBankcode("2015");
		model1.setId("1");
		model1.setProducttype("A");
		model1.setMoneyclass("0");

		ZxbMoneyInRecModel model2 = new ZxbMoneyInRecModel();
		model2.setAssetid("222222222222222222222");
		model2.setBankcardnum("622246234188");
		model2.setBankcode("2017");
		model2.setId("2");
		model2.setProducttype("B");
		model2.setMoneyclass("0");

		ZxbMoneyInRecModel model3 = new ZxbMoneyInRecModel();
		model3.setAssetid("3333333333333333333");
		model3.setBankcardnum("6200246234188");
		model3.setBankcode("2850");
		model3.setId("3");
		model3.setProducttype("C");
		model3.setMoneyclass("1");

		list.add(model1);
		list.add(model2);
		list.add(model3);
		return list;
	}

}
