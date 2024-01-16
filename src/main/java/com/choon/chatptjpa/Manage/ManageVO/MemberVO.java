package com.choon.chatptjpa.Manage.ManageVO;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import oracle.sql.BLOB;

@Entity
@Table(
   name = "members"
)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberVO 
{
   @Id
   @Column(
      length = 255
   )
   private String id;
   @Column(
      length = 255
   )
   private String email;
   @Column(
      length = 255
   )
   private String password;
   @Column(
      length = 255
   )
   private String name;
   @Column(
      length = 255
   )
   private String gender;
   @Column(
      length = 255
   )
   private String role;
   @Column(
      length = 255
   )
   private String birth;

   private String withKakao;

   private String kakaoCode;

}