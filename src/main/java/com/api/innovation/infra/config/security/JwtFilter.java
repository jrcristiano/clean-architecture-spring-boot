package com.api.innovation.infra.config.security;

import java.io.IOException;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.api.innovation.infra.config.security.dto.ResponseDTO;
import com.api.innovation.infra.utils.token.TokenUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JwtFilter extends OncePerRequestFilter {

    private List<String> openEndpoints;

    JwtFilter(List<String> openEndpoints) {
        this.openEndpoints = openEndpoints;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
        throws ServletException, IOException {

        if (this.openEndpoints.contains(request.getRequestURI())) {
            filterChain.doFilter(request, response);
            return;
        }
        
        String headerAuthorization = request.getHeader("Authorization");

        if (headerAuthorization == null) {
            this.apiResponse(response, "Empty or invalid bearer token", 400);
            return;
        }

        Authentication auth = TokenUtil.decodeToken(request);
        
        if (auth == null) {
            this.apiResponse(response, "Unauthorized", 401);
            return;
        }

        SecurityContextHolder.getContext().setAuthentication(auth);
        filterChain.doFilter(request, response);
    }

    private HttpServletResponse apiResponse(HttpServletResponse response, String message, int httpStatusCode)
        throws IOException {
            ResponseDTO responseDTO = new ResponseDTO(message, httpStatusCode);
                
            response.setStatus(responseDTO.getStatus());
            response.setContentType("application/json");

            ObjectMapper mapper = new ObjectMapper();
            response.getWriter().print(mapper.writeValueAsString(responseDTO));
            response.getWriter().flush();

            return response;
    }
}
