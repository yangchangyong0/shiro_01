package com.ycy.interceptor;

/**
 * Created by Administrator on 2015/10/10 0010.
 */

import com.ycy.model.ActiveUser;
import com.ycy.model.SysPermission;
import com.ycy.util.ResourcesUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 授权拦截器
 */
public class SysPermissionInterceptor implements HandlerInterceptor{

    //在执行handler之前来执行的
    //用于用户认证校验、用户权限校验
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        //得到请求的url
        String url = request.getRequestURI();
        //从配置中取逆名访问url
        /*************************************************匿名地址**********************************************/
        List<String> open_urls = ResourcesUtil.gekeyList("config/anonymousURL");
        //遍历公开 地址，如果是公开 地址则放行
        for(String open_url:open_urls){
            if(url.indexOf(open_url)>=0){
                //如果是公开 地址则放行
                return true;
            }
        }
        /*************************************************公用地址***********************************************/
        //从配置文件中获取公共访问地址
        List<String> common_urls = ResourcesUtil.gekeyList("config/commonURL");
        //遍历公用 地址，如果是公用 地址则放行
        for(String common_url:common_urls){
            if(url.indexOf(common_url)>=0){
                //如果是公开 地址则放行
                return true;
            }
        }
        /*************************************************获取session***********************************************/
        //获取session
        HttpSession session = request.getSession();
        ActiveUser activeUser = (ActiveUser) session.getAttribute("activeUser");
        //从session中取权限范围的url

        List<SysPermission> permissions = activeUser.getPermissions();
        for(SysPermission sysPermission:permissions){
            //权限的url
            String permission_url = sysPermission.getUrl();
            System.out.println(url);
            System.out.println(permission_url);
            if(url.endsWith(".css")||url.endsWith(".js")||url.endsWith(".jsp")){
                return true;
            }else{
                if(url.indexOf(permission_url)>=0){
                    //如果是权限的url 地址则放行
                    return true;
                }
            }

        }
        //执行到这里拦截，跳转到登陆页面，用户进行身份认证
        request.getRequestDispatcher("/pages/jsp/refuse.jsp").forward(request, response);
        //如果返回false表示拦截不继续执行handler，如果返回true表示放行
        return false;
    }
    //在执行handler返回modelAndView之前来执行
    //如果需要向页面提供一些公用 的数据或配置一些视图信息，使用此方法实现 从modelAndView入手
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        System.out.println("HandlerInterceptor1...postHandle");

    }
    //执行handler之后执行此方法
    //作系统 统一异常处理，进行方法执行性能监控，在preHandle中设置一个时间点，在afterCompletion设置一个时间，两个时间点的差就是执行时长
    //实现 系统 统一日志记录
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        System.out.println("HandlerInterceptor1...afterCompletion");
    }
}
