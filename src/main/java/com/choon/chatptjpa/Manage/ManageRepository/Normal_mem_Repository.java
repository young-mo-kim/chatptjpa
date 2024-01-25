package com.choon.chatptjpa.Manage.ManageRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.choon.chatptjpa.Manage.ManageDTO.Normal_memDTO;
import com.choon.chatptjpa.Manage.ManageVO.Normal_memVO;


public interface Normal_mem_Repository extends JpaRepository<Normal_memVO, Integer> 
{
    
    List<Normal_memDTO> findByNnum(Integer nnum);
    // Normal_mem_Repository 인터페이스 내
    @Query("SELECT m FROM Normal_memVO m WHERE m.member.id NOT LIKE %:pattern%")
    List<Normal_memVO> findmembers(@Param("pattern") String pattern);
    
    @Query("SELECT m FROM Normal_memVO m WHERE m.member.id = :memberId")
    Normal_memVO findByMember(@Param("memberId") String memberId);
}
 