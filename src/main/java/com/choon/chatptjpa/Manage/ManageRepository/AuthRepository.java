package com.choon.chatptjpa.Manage.ManageRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.choon.chatptjpa.Manage.ManageVO.MemberVO;
import java.util.List;


public interface AuthRepository extends JpaRepository<MemberVO, String> {
    MemberVO findByIdAndPassword(String id , String password);
 
    String findByNameAndEmail(String name, String email);
 }
 