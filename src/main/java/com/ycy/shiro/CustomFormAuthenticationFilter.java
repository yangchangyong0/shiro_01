package com.ycy.shiro;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2015/10/20 0020.
 */
public class CustomFormAuthenticationFilter extends FormAuthenticationFilter  {
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        // 校验验证码
        // 从session获取正确的验证码
        HttpSession session = ((HttpServletRequest)request).getSession();
        //页面输入的验证码
        String randomcode = request.getParameter("randomcode");
        //从session中取出验证码
        String validateCode = (String) session.getAttribute("validateCode");
        if (randomcode!=null&&validateCode!=null&&!randomcode.equals(validateCode)) {
            // randomCodeError表示验证码错误
            request.setAttribute("shiroLoginFailure", "randomCodeError");
            //拒绝访问，不再校验账号和密码
            return true;
        }

        return super.onAccessDenied(request, response, mappedValue);
    }
}
