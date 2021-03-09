package com.liziyuan.hope.log.manager.core.utils;

import com.liziyuan.hope.log.manager.core.model.UserInfo;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet 相关工具类
 *
 * @author zqz
 * @version 1.0
 * @date 2020-05-07 17:56
 */
public class ServletUtils {

    /**
     * user-key in session
     */
    private static final String SESSION_USER_INFO_KEY = "userInfo";

    /**
     * 获取 HttpServletRequest
     *
     * @return HttpServletRequest
     */
    public static HttpServletRequest getHttpServletRequest() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert servletRequestAttributes != null;
        return servletRequestAttributes.getRequest();
    }

    /**
     * 获取HttpSession
     *
     * @return HttpSession
     */
    public static HttpSession getHttpSession() {
        return getHttpServletRequest().getSession();
    }

    /**
     * 获取session中的用户信息
     *
     * @return session中的用户信息
     */
    public static UserInfo getSessionUserInfo() {
        return (UserInfo) getHttpSession().getAttribute(SESSION_USER_INFO_KEY);
    }
}
