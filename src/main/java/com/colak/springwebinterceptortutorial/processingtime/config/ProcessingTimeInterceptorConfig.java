package com.colak.springwebinterceptortutorial.processingtime.config;

import com.colak.springwebinterceptortutorial.processingtime.interceptor.RequestProcessingTimeInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ProcessingTimeInterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor( new RequestProcessingTimeInterceptor())
                .addPathPatterns("/api/v1/processingTimeService/**");
    }

}
