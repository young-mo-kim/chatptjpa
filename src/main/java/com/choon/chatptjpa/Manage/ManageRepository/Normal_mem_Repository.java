package com.choon.chatptjpa.Manage.ManageRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.choon.chatptjpa.Manage.ManageDTO.Normal_memDTO;
import com.choon.chatptjpa.Manage.ManageVO.Normal_memVO;


public interface Normal_mem_Repository extends JpaRepository<Normal_memVO, Integer> {
    List<Normal_memDTO> findByNnum(Integer nnum);
 }
 