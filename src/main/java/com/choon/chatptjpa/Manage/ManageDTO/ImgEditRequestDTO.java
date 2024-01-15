package com.choon.chatptjpa.Manage.ManageDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ImgEditRequestDTO {
    private Long editRequestId;
    private String upPhotoId;
    private boolean editRequestStatus;
    private String imgEditcomment;
    private String imgEdit;
    private String beforeData;
    private String afterData;
}