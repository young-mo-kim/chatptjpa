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
    private String weight;
    private String height;
    private String purpose;
    private String activity;
    private String nickname;
 
}
