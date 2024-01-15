package com.choon.chatptjpa.Manage.ManageDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO 
{
    private Integer tnum;
    private Integer nnum;
    private String timg;
    private String userimg;
    private String userid;
    private String username;
    private String usertype;
    private String userstatus;
}
