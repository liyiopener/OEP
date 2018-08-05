package com.sut.oep.Interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

    public class MyInterceptor implements HandlerInterceptor {
    Logger logger = LoggerFactory.getLogger(MyInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        logger.info(request.getRequestURI());
        // TODO Auto-generated method stub
        logger.info("------preHandle------");
        //获取session
        HttpSession session = request.getSession(true);
        //判断用户ID是否存在，不存在就跳转到登录界面
        if(session.getAttribute("uid") == null){
            logger.info("------:跳转到首页！");
            response.sendRedirect(request.getContextPath()+"/");
            return false;
        }else{
            session.setAttribute("uid", session.getAttribute("uid"));
            session.setMaxInactiveInterval(20*60);
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // TODO Auto-generated method stub

    }

}