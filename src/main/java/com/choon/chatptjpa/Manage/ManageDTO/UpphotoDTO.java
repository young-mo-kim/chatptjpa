package com.choon.chatptjpa.Manage.ManageDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpphotoDTO 
{
    private Long upphotoid;
    private int nnum;
    private int foodnum;
    private String category;
    private String uploaddate;
    private String mass;
    private String candidate1;
    private String candidate2;
    private String candidate3;
    private String predictrate;
    private String candidate1rate;
    private String candidate2rate;
    private String candidate3rate;
}
