// Source code is decompiled from a .class file using FernFlower decompiler.
package com.choon.chatptjpa.Manage.ManageController;

import com.choon.chatptjpa.Manage.ManageService.AuthService;
import com.choon.chatptjpa.Manage.ManageService.ManageService;
import com.choon.chatptjpa.utils.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
   private static final Logger log = LoggerFactory.getLogger(AuthController.class);
   @Autowired
   private HttpServletRequest request;
   private final AuthService authService;
   private final ManageService mService;

   @PostMapping({"/admin_login"})
   public ResponseEntity<Map<String, String>> login(@RequestBody Map<String, String> params) {
      String token = this.authService.login((String)params.get("userName"), (String)params.get("password"));
      if (token == null) {
         Map<String, String> errorResponse = new HashMap();
         return ResponseEntity.badRequest().body(errorResponse);
      } else {
         String name = "";
         String role = this.mService.getRole((String)params.get("userName"));
         Map<String, String> responseData = new HashMap();
         responseData.put("token", token);
         responseData.put("role", role);
         responseData.put("name", name);
         return ResponseEntity.ok(responseData);
      }
   }

   @GetMapping({"/checkAdmin"})
   public ResponseEntity<?> checkToken() {
      String authorizationHeader = this.request.getHeader("Authorization");
      String token = JwtUtil.extractToken(authorizationHeader);
      String userRole = JwtUtil.getRole(token);
      return ResponseEntity.ok().body(userRole);
   }

   public AuthController(final AuthService authService, final ManageService mService) {
      this.authService = authService;
      this.mService = mService;
   }
}
