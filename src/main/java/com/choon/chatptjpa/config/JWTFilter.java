// Source code is decompiled from a .class file using FernFlower decompiler.
package com.choon.chatptjpa.config;

import com.choon.chatptjpa.Manage.ManageService.AuthService;
import com.choon.chatptjpa.utils.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

public class JWTFilter extends OncePerRequestFilter 

{
   private static final Logger log = LoggerFactory.getLogger(JWTFilter.class);
   private final AuthService authService;
   private final String secretKey;

   protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
      String authorization = request.getHeader("Authorization");
      log.info("\ub85c\uae45 - authorization: {}", authorization);
      log.info("\ub85c\uae45 - Request Method: {}", request.getMethod());
      log.info("\ub85c\uae45 - Request URI: {}", request.getRequestURI());
      if (authorization != null && authorization.startsWith("Bearer ") && authorization.length() != "Bearer null".length()) {
         String token = authorization.split(" ")[1];
         if (JwtUtil.isExpired(token, this.secretKey)) {
            log.error("\ub85c\uae45 - \ud1a0\ud070\uc774 \ub9cc\ub8cc\ub418\uc5c8\uc2b5\ub2c8\ub2e4.");
            filterChain.doFilter(request, response);
         } else {
            String userName = JwtUtil.getUserName(token, this.secretKey);
            log.info("\ub85c\uae45 - name(jwtfilter): {}", userName);
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userName, (Object)null, List.of(new SimpleGrantedAuthority("USER")));
            authenticationToken.setDetails((new WebAuthenticationDetailsSource()).buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            filterChain.doFilter(request, response);
         }
      } else {
         log.warn("\ub85c\uae45 - authorization\uc774 \uc5c6\uac70\ub098, \uc798\ubabb\ubcf4\ub0c4.");
         filterChain.doFilter(request, response);
      }
   }

   public JWTFilter(final AuthService authService, final String secretKey) {
      this.authService = authService;
      this.secretKey = secretKey;
   }
}
