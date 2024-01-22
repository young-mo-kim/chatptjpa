package com.choon.chatptjpa.Manage.ManageDTO;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PTeacherDTO implements Serializable {
    private Integer tnum;
    private String trainer_id;
    private String trainercomment;
    private String trainerintro;
    private String region;
    private String awards1;
    private String awards2;
    private String awards3;
    private String awards4;
    private String awards5;
    private String starttime;
    private String endtime;
    private String mainimage;
    private String SUBIMAGE1;
    private String SUBIMAGE2;
    private int ISVERIFIED;   
    private String gym;
}