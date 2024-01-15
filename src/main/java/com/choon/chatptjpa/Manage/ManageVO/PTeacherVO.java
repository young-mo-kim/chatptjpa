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

@Entity
@Table(
   name = "trainer_mem",
   uniqueConstraints = {@UniqueConstraint(
   columnNames = {"tnum", "trainerId"}
)}
)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PTeacherVO {
   @Id
   @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "trainer_mem_seq"
   )
   @SequenceGenerator(
      name = "trainer_mem_seq",
      sequenceName = "trainer_mem_seq",
      allocationSize = 1,
      initialValue = 50000
   )
   private Integer tnum;
   @ManyToOne(
      fetch = FetchType.LAZY
   )
   @JoinColumn(
      name = "trainerId",
      referencedColumnName = "id"
   )
   private MemberVO member;
   @Column(
      length = 255
   )
   private String trainerComment;
   @Lob
   private String trainerIntro;
   private String address;
   private String contactTime;
   private String awards;
   private String awards1;
   private String awards2;
   private String awards3;
   private String awards4;
   @Column(
      columnDefinition = "VARCHAR(255) DEFAULT '\ubbf8\uc2b9\uc778'"
   )
   private String status;

   public String getMemberName() {
      return this.member != null ? this.member.getName() : null;
   }

   public String getMemberId() {
      return this.member != null ? this.member.getId() : null;
   }
}