package org.tonykuo.ws.interceptor;

import java.time.Duration;
import java.time.Instant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.tonykuo.service.util.LogUtil;

public class HelloInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        
        // LogUtil.info("---Before Method Execution---");
        
        Instant startTime = Instant.now();
        request.setAttribute("startTime", startTime);
        
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        // LogUtil.info("---after Method Execution---");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // LogUtil.info("---complete Method Execution---");
        Instant startTime = (Instant) request.getAttribute("startTime");
        LogUtil.info("executed time = " + (Duration.between(startTime, Instant.now())));
    }

}
