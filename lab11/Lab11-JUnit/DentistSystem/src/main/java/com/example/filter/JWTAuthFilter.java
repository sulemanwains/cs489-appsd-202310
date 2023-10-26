package com.example.filter;

import com.example.Service.Impl.UserDetailsService;
import com.example.utils.JWTManagementUtilityService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JWTAuthFilter extends OncePerRequestFilter {
    private UserDetailsService userDetailsService;
    private JWTManagementUtilityService jwtManagementUtilityService;

    public JWTAuthFilter(UserDetailsService cityLibraryUserDetailsService,
                         JWTManagementUtilityService jwtManagementUtilityService) {
        this.userDetailsService = cityLibraryUserDetailsService;
        this.jwtManagementUtilityService = jwtManagementUtilityService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader = request.getHeader("Authorization");
        String jwtToken = null;
        String username = null;
        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwtToken = authorizationHeader.substring(7);
            username = jwtManagementUtilityService.extractUsername(jwtToken);
        }
        if(username != null
                && SecurityContextHolder.getContext().getAuthentication() == null) {
            var userDetails = userDetailsService.loadUserByUsername(username);
            if(jwtManagementUtilityService.validateToken(jwtToken, userDetails)) {
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails,
                        null, userDetails.getAuthorities());
                authToken
                        .setDetails(
                                new WebAuthenticationDetailsSource()
                                        .buildDetails(request)
                        );
                SecurityContextHolder.getContext()
                        .setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request, response);
    }
}
