package com.colak.springwebinterceptortutorial.authtoken.interceptor;

import com.colak.springwebinterceptortutorial.authtoken.service.AuthTokenService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@RequiredArgsConstructor
public class AuthTokenInterceptor implements HandlerInterceptor {

    private final AuthTokenService authTokenService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authToken = authTokenService.getAuthToken();
        if (authToken == null) {
            // Token is null; return an error response
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // Set the HTTP status code to 401 Unauthorized
            response.getWriter().write("Authentication token not found or generated"); // Set the response message
            return false; // Stop further processing
        }
        request.setAttribute("authToken", authToken);
        return true; // Continue processing for other requests
    }
}
