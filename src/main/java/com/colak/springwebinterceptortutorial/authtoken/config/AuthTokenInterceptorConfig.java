package com.colak.springwebinterceptortutorial.authtoken.config;

import com.colak.springwebinterceptortutorial.authtoken.annotation.ThirdPartyAuthTokenArgumentResolver;
import com.colak.springwebinterceptortutorial.authtoken.interceptor.AuthTokenInterceptor;
import com.colak.springwebinterceptortutorial.authtoken.service.AuthTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class AuthTokenInterceptorConfig implements WebMvcConfigurer {

    private final AuthTokenService authTokenService;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthTokenInterceptor(authTokenService))
                .addPathPatterns("/api/thirdPartyService1/**");
    }

    // configuration for custom annotation
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new ThirdPartyAuthTokenArgumentResolver());
    }
}
