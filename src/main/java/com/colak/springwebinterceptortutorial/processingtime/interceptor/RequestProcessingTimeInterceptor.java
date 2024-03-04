package com.colak.springwebinterceptortutorial.processingtime.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * In Spring Boot, an interceptor allows you to intercept and perform pre-processing or post-processing logic for HTTP
 * requests before they reach a controller’s request mapping method, or after they have been processed by the controller method.
 */
@Slf4j
public class RequestProcessingTimeInterceptor implements HandlerInterceptor {

    // Called before the actual handler is executed, but the view is not generated yet.
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) {
        long startTime = System.currentTimeMillis();
        log.info("preHandle Request URL: {} Start Time: {}",
                request.getRequestURL().toString(),
                startTime);

        request.setAttribute("startTime", startTime);
        // If “preHandle” returns “true”, the request processing continues
        // if returned false, we need to make sure 'response' is sent
        return true;
    }

    // Called after the handler is executed but before the view is rendered or the response is sent to the client.
    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView) {
        log.info("postHandle Request URL: {} ContentType : {}",
                request.getRequestURL().toString(),
                response.getContentType());
        // we can add attributes in the modelAndView and use that in the view page
    }

    // Called after the complete request has finished and the view was generated.
    // The method is called regardless of the outcome of the request.
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception ex) {
        long endTime = System.currentTimeMillis();
        long startTime = (Long) request.getAttribute("startTime");
        log.info("afterCompletion Request URL:  {} End Time : {} Time Taken : {}",
                request.getRequestURL().toString(),
                endTime,
                endTime - startTime);
    }
}
