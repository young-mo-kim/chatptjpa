package com.choon.chatptjpa.Manage.ManageDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Normal_memDTO {
    private Integer nnum;
    private String normal_id;
    private double weight;
    private double height;
    private int purpose;
    private String nickname;
    private int activity;
    private double target_weight;
    private String NM_PROFILEIMG;
    private String REGION;
 
}
