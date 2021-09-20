package com.example.relacionesentretablas.seguridad.infrastructure.filter;

import com.example.relacionesentretablas.persona.application.PersonaServiceimpl;
import com.example.relacionesentretablas.seguridad.infrastructure.utility.JWTUtil;
import org.hibernate.annotations.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class JwtFilter extends OncePerRequestFilter {
    @Autowired
    private JWTUtil jwtUtil;
    @Autowired
    PersonaServiceimpl personaServiceimpl;
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String authorization = httpServletRequest.getHeader("Authorization");
        String token = null;
        String userName = null;
        if(authorization != null && authorization.startsWith("Bearer ")) {
            token = authorization.substring(7);
            userName = jwtUtil.getUsernameFromToken(token);

        }
        if(userName != null &&SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = personaServiceimpl.loadUserByUsername(userName);
            if(jwtUtil.validateToken(token, userDetails)) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails, userDetails.getAuthorities(),userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(httpServletRequest)
                );
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

            }

        }
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}
