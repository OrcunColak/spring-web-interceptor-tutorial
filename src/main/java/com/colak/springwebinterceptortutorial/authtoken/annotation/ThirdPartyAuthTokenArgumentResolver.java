package com.colak.springwebinterceptortutorial.authtoken.annotation;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * “HandlerMethodArgumentResolver” interface, allows custom handling of method arguments by overriding two methods
 * 1. “supportsParameter” and
 * 2.“resolveArgument”.
 */
@Component
public class ThirdPartyAuthTokenArgumentResolver implements HandlerMethodArgumentResolver {

    // The “supportsParameter” method is responsible for determining if the resolver can be applied to a specific method parameter.
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        // It checks if the parameter’s type is String, it also checks if the parameter has the @ThirdPartyAuthToken annotation.
        // This part ensures that this resolver is applied only to method parameters annotated with @ThirdPartyAuthToken.
        // If both conditions are met, it returns true, indicating that this resolver can handle the parameter.
        return parameter.getParameterType().equals(String.class) &&
               parameter.hasParameterAnnotation(ThirdPartyAuthToken.class);
    }

    // The “resolveArgument” method is responsible for actually resolving the method argument.
    // It provides the logic for extracting the value of the argument.
    @Override
    public Object resolveArgument(
            MethodParameter parameter,
            ModelAndViewContainer mavContainer,
            NativeWebRequest webRequest,
            WebDataBinderFactory binderFactory
    ) {
        // Retrieves the underlying HttpServletRequest object from the provided NativeWebRequest.
        // The NativeWebRequest is a more abstract representation of a web request, and the HttpServletRequest is extracted from it.
        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();

        // Retrieve the custom value from wherever it was set in your interceptor
        // Finally, it returns the retrieved authToken, which will be used as the value for the method argument of type String.
        return request.getAttribute("authToken");
    }
}
