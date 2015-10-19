package com.ycy.controller;

import com.ycy.Exception.CustomException;
import com.ycy.model.ActiveUser;
import com.ycy.service.SysService;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 
 * <p>Title: LoginController</p>
 * <p>Description: 登陆和退出</p>
 */
@Controller
public class LoginController {
	
	@Autowired
	private SysService sysService;
	//用户登陆提交方法
	/*@RequestMapping("/login")
	public String login(HttpSession session,String usercode,String password,String randomcode)throws Exception{

		//校验验证码
		//从session获取正确的验证码
		String validateCode = (String)session.getAttribute("validateCode");
		if(!randomcode.equals(validateCode)){
			//抛出异常：验证码错误
			throw new CustomException("验证码 错误 ！");
		}
		//用户身份认证
		ActiveUser activeUser = sysService.authenticat(usercode, password);
		//记录session
		session.setAttribute("activeUser", activeUser);
		//重定向到商品查询页面
		return "redirect:/first";
	}

	//用户退出
	@RequestMapping("/logout")
	public String logout(HttpSession session)throws Exception{
		//session失效
		session.invalidate();
		//重定向到商品查询页面
		return "redirect:/items/queryItems";

	}*/
	@RequestMapping("/login")
	public  String login(HttpServletRequest request)throws Exception{
		//如果登录失败从request中获取认证异常信息，shrioLoginFailure就是shiro异常类的全限定名
		String exceptionClassName=request.getParameter("shiroLoginFailure");
		//根据shrio返回的异常路径判断，抛出指定异常信息
		if (exceptionClassName!=null){
			if(UnknownAccountException.class.getName().equals(exceptionClassName)){
				//抛出异常
				throw new CustomException("账户不存在");
			}
		}else if(IncorrectCredentialsException.class.getName().equals(exceptionClassName)){
				throw new CustomException("用户名/密码错误");
		}
		return "login";
	}

	

}
