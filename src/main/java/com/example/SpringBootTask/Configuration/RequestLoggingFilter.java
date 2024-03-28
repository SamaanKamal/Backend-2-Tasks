package com.example.SpringBootTask.Configuration;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.logging.Logger;

@Component
public class RequestLoggingFilter extends OncePerRequestFilter {
    private static final Logger LOGGER = Logger.getLogger(RequestLoggingFilter.class.getName());

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {
        long startTime = System.currentTimeMillis();
        try {
            filterChain.doFilter(request, response);
        } finally {
            long duration = System.currentTimeMillis() - startTime;
            LOGGER.info(buildLogMessage(request, response, duration));
        }
    }
    private String buildLogMessage(HttpServletRequest request, HttpServletResponse response, long duration) {
        StringBuilder message = new StringBuilder();
        message.append(request.getMethod()).append(" ");
        message.append(request.getRequestURI());
        message.append(" - ");
        message.append(response.getStatus());
        message.append(" - ");
        message.append(duration).append("ms");
        return message.toString();
    }
}
