package com.chic.qh.configuration;

import org.apache.logging.log4j.LogManager;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Description:
 * @author: xumingwei
 * @date: 2023—04—07 14:30
 */
public class LoginInterceptor implements HandlerInterceptor {

    protected static org.apache.logging.log4j.Logger logger = LogManager.getLogger(LoginInterceptor.class);

    /**
     * 进入controller层之前拦截请求
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String auth = httpServletRequest.getHeader("Authorization");
        String uri = httpServletRequest.getRequestURI();
        logger.info("uri:{} , with auth: {}", uri, auth);
        return true;
    }

    protected void buildResp(HttpServletResponse httpServletResponse) throws IOException {
        PrintWriter pw = httpServletResponse.getWriter();
        pw.write("{\"returnCode\":1001,\"returnMsg\":\"no login\"}");
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
    }
}