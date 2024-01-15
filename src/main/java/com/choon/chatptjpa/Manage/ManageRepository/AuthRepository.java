package com.choon.chatptjpa.Manage.ManageRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.choon.chatptjpa.Manage.ManageVO.MemberVO;

public interface AuthRepository extends JpaRepository<MemberVO, String> {
    MemberVO findByNameAndPassword(String name, String password);
 
    String findByNameAndEmail(String name, String email);
 }
 