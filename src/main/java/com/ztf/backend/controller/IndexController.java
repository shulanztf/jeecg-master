package com.ztf.backend.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.activiti.engine.identity.User;
import org.jeecgframework.p3.core.utils.common.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ztf.backend.model.UserModel;

/**
 * @Title: IndexController.java
 * @Description: TODO(用一句话描述该文件做什么)
 * @author zhaotf
 * @date 2018年4月27日 下午3:21:29
 * @see {@linkplain https://www.cnblogs.com/andyfengzp/p/6434287.html}
 * @see {@linkplain https://blog.csdn.net/a60782885/article/details/70244305}
 */
@Controller
@RequestMapping("/index")
public class IndexController {

	private final Gson gson = new GsonBuilder().setDateFormat("yyyyMMddHHmmss").create();

	/**
	 * 主页面
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String sessionId = (String) session.getAttribute("sessionId");
		if (StringUtils.isNotBlank(sessionId)) { // sessionId不为空
			System.out.println("main sessionId:" + sessionId);
			model.addAttribute("usertext", sessionId);
			return "index";
		} else { // sessionId为空
			return "redirect:/login";
		}
	}

	/**
	 * 登录
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	public String doLogin(HttpServletRequest request) {
		System.out.println("I do real login here");
		HttpSession session = request.getSession();
		String sessionId = UUID.randomUUID().toString();
		session.setAttribute("sessionId", sessionId);
		System.out.println("login sessionId:" + sessionId);
		return "redirect:/main";
	}

	/**
	 * 加载登录页面
	 * 
	 * @param request
	 * @param username
	 * @return
	 */
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(HttpServletRequest request, String username) {
		request.getSession().setAttribute("user", gson.toJson(new UserModel(username, "123456")));
		return "login";
	}

	@RequestMapping(value = "index")
	public String index(HttpServletRequest request, Model model) {
		User user = gson.fromJson(request.getSession().getAttribute("user").toString(), User.class);
		model.addAttribute("user", user);
		return "index";
	}

}
