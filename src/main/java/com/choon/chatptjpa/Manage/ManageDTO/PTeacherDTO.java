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
    private String trainerComment;
    private String trainerIntro;
    private String address;
    private String contactTime;
    private String awards;
    private String awards1;
    private String awards2;
    private String awards3;
    private String awards4;
    private String status;
 
}