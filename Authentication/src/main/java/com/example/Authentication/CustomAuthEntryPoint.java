package com.example.Authentication;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAuthEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException)
            throws IOException, ServletException {

        // Set response status
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        // Set content type
        response.setContentType("application/json");

        // Send custom JSON message
        response.getWriter().write("Invalid username or password. Please try again");
    }
}

