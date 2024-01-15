// Source code is decompiled from a .class file using FernFlower decompiler.
package com.choon.chatptjpa.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {
   @Value("${jwt.secret}")
   private static String secretKey;

   public JwtUtil() {
   }

   public static String extractToken(String authorizationHeader) {
      return authorizationHeader != null && authorizationHeader.startsWith("Bearer ") ? authorizationHeader.substring(7) : null;
   }

   public static String getUserName(String token, String secretKey) {
      JwtUtil.secretKey = secretKey;
      return (String)((Claims)Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody()).get("userName", String.class);
   }

   public static String getID(String token) {
      return (String)((Claims)Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody()).get("userName", String.class);
   }

   public static String getRole(String token) {
      try {
         Claims claims = (Claims)Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
         return (String)claims.get("role", String.class);
      } catch (ExpiredJwtException var2) {
         System.out.println("Token expired: " + var2.getMessage());
         return null;
      } catch (UnsupportedJwtException var3) {
         System.out.println("Unsupported JWT: " + var3.getMessage());
         return null;
      } catch (MalformedJwtException var4) {
         System.out.println("Malformed JWT: " + var4.getMessage());
         return null;
      } catch (IllegalArgumentException var5) {
         System.out.println("Illegal argument: " + var5.getMessage());
         return null;
      }
   }

   public static boolean isExpired(String token, String secretKey) {
      return ((Claims)Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody()).getExpiration().before(new Date());
   }

   public static String createJwt(String userName, String role, String secretKey, Long expireMs) {
      Claims claims = Jwts.claims();
      claims.put("userName", userName);
      claims.put("role", role);
      return Jwts.builder().setClaims(claims).setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis() + expireMs)).signWith(SignatureAlgorithm.HS256, secretKey).compact();
   }
}
