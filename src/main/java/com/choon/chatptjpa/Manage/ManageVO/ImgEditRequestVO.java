package com.choon.chatptjpa.Manage.ManageVO;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(
   name = "imgediterequest"
)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ImgEditRequestVO {
    @Id
    @GeneratedValue(
       strategy = GenerationType.SEQUENCE,
       generator = "eidtrequest_seq"
    )
    @SequenceGenerator(
       name = "eidtrequest_seq",
       sequenceName = "eidtrequest_seq",
       allocationSize = 1
    )
    private Long editRequestId;
    private String upPhotoId;
    private String imgEditcomment;
    private String imgEdit;
    @Column(
       columnDefinition = "NUMBER(1) DEFAULT 0"
    )
    private Integer editRequestStatus;
    private String beforeData;
    private String afterData;
}