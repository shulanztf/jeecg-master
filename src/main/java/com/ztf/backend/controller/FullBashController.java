package com.ztf.backend.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.enmus.ExcelType;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ztf.backend.model.ZxbMoneyInRecModel;
import com.ztf.backend.service.FullBashService;

/**
 * 
 * @Title: FullBashController
 * @Description:
 * @Author: zhaotf
 * @Since:2017年7月14日 下午2:14:18
 * @Version:1.0
 */
@Controller
@RequestMapping("/fullBash")
public class FullBashController {

	@Resource
	private FullBashService fullBashService;

	/**
	 * 导出
	 * 
	 * @param request
	 * @param modelMap
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(params = "exportHeartQueryXls")
	public String exportHeartQueryXls(HttpServletRequest request, ModelMap modelMap) throws Exception {
		List<ZxbMoneyInRecModel> incomes = this.fullBashService.findMoneyInRecList(request);
		modelMap.put(NormalExcelConstants.FILE_NAME, "资金入账履历信息");
		modelMap.put(NormalExcelConstants.CLASS, ZxbMoneyInRecModel.class);
		ExportParams ep = new ExportParams("资金入账信息列表", "导出人:" + ResourceUtil.getSessionUserName().getRealName(),
				"导出信息");
		ep.setType(ExcelType.XSSF);
		modelMap.put(NormalExcelConstants.PARAMS, ep);
		modelMap.put(NormalExcelConstants.DATA_LIST, incomes);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}

}
