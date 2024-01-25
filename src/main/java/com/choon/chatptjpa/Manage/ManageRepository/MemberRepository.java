package com.choon.chatptjpa.Manage.ManageRepository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.choon.chatptjpa.Manage.ManageVO.MemberVO;

public interface MemberRepository extends JpaRepository<MemberVO, String> 
{
    List<MemberVO> findByName(String name);
 
    @Query("SELECT n.nickname FROM Normal_memVO n WHERE n.member.id = :id")
    String getNickname(@Param("id") String id);
 
    @Query("SELECT m.role FROM MemberVO m WHERE m.id = :id")
    String getRole(@Param("id") String id);
 
    @Query("SELECT m.name FROM MemberVO m WHERE m.id = :id")
    String getName(@Param("id") String id);

    Page<MemberVO> findAll(Pageable pageable);
 }