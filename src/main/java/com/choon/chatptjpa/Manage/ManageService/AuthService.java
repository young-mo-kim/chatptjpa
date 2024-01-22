package com.choon.chatptjpa.Manage.ManageService;


import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.choon.chatptjpa.Manage.ManageRepository.AuthRepository;
import com.choon.chatptjpa.Manage.ManageVO.MemberVO;
import com.choon.chatptjpa.utils.JwtUtil;

@Service
public class AuthService {
   private static final Logger log = LoggerFactory.getLogger(AuthService.class);
   @Autowired
   private AuthRepository aRepository;
   @Value("${jwt.secret}")
   private String secretKey;
   private Long expiredMs = 3600000L;

   public AuthService() {
   }

   public String login(String userName, String password) {

      


      MemberVO userVO = this.getUser(userName, password);
      if (userVO != null) {
         String role = userVO.getRole().toString();
         return JwtUtil.createJwt(userName, role, this.secretKey, this.expiredMs);
      } else {
         return null;
      }
   }

   public MemberVO getUser(String username, String password) {
      MemberVO userVO = null;
      userVO = this.aRepository.findByIdAndPassword(username, password);
      System.out.println(userVO.toString());
      return userVO;
   }

   public String findId(String name, String email) {
      return this.aRepository.findByNameAndEmail(name, email);
   }
}
