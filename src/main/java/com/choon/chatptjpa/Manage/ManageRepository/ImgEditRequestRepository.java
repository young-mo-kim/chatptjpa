package com.choon.chatptjpa.Manage.ManageRepository;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.choon.chatptjpa.Manage.ManageVO.ImgEditRequestVO;
import com.choon.chatptjpa.Manage.ManageVO.UpphotoVO;


public interface ImgEditRequestRepository extends JpaRepository<ImgEditRequestVO, Long> 
{
    @Query("SELECT i.upphotoid FROM ImgEditRequestVO i WHERE i.edit_request_id = :editRequestId")
    UpphotoVO findUpphotoByEditRequestId(@Param("editRequestId") Long editRequestId);
    
}
