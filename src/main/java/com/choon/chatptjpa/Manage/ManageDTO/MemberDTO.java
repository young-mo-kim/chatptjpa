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
public class MemberDTO implements Serializable {
    private String id;
    private String email;
    private String password;
    private String name;
    private String gender;
    private String role;
    private String birth;

}