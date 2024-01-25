package com.choon.chatptjpa.Manage.ManageRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.choon.chatptjpa.Manage.ManageVO.PTeacherVO;

public interface PTeacherRepository extends JpaRepository<PTeacherVO, Integer> {
    @Query("SELECT pt FROM PTeacherVO pt WHERE pt.member.id = :memberId")
    List<PTeacherVO> findByMemberId(@Param("memberId") String memberId);
 
    List<PTeacherVO> findByISVERIFIED(int iSVERIFIED);

    @Query("SELECT pt FROM PTeacherVO pt WHERE pt.member.id = :id")
    PTeacherVO findByMember(@Param("id") String id);
}
 