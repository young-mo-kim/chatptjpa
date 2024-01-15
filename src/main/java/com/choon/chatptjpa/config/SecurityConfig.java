// Source code is decompiled from a .class file using FernFlower decompiler.
package com.choon.chatptjpa.config;

import  com.choon.chatptjpa.Manage.ManageService.AuthService;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
   private final AuthService authService;
   @Value("${jwt.secret}")
   private String secretKey;

   @Bean
   public CorsConfigurationSource corsConfigurationSource() {
      CorsConfiguration corsConfiguration = new CorsConfiguration();
      corsConfiguration.setAllowCredentials(true);
      corsConfiguration.setAllowedOrigins(List.of("http://localhost:8080", "http://localhost:8081", "https://chunsik.shop"));
      corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "OPTIONS", "DELETE", "OPTIONS"));
      corsConfiguration.setAllowedHeaders(List.of("*"));
      UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
      urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
      return urlBasedCorsConfigurationSource;
   }

   @Bean
   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
      http.csrf((csrf) -> {
         csrf.disable();
      }).cors((cors) -> {
         cors.configurationSource(this.corsConfigurationSource());
      }).formLogin((login) -> {
         login.disable();
      }).httpBasic((basic) -> {
         basic.disable();
      }).authorizeHttpRequests((auth) -> {
         ((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)auth.requestMatchers(new String[]{"/login", "/checkToken", "/images/**", "/service/**", "/admin_login"})).permitAll().anyRequest()).authenticated();
      }).addFilterBefore(new JWTFilter(this.authService, this.secretKey), UsernamePasswordAuthenticationFilter.class).sessionManagement((session) -> {
         session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
      }).logout((logout) -> {
         logout.disable();
      });
      return (SecurityFilterChain)http.build();
   }

   @Bean
   public PasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
   }

   public SecurityConfig(final AuthService authService) {
      this.authService = authService;
   }
}
