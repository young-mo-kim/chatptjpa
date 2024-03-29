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
   name = "normal_mem",
   uniqueConstraints = {@UniqueConstraint(
   columnNames = {"nnum", "normalId"}
)}
)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Normal_memVO {
   @Id
   @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "normal_mem_seq"
   )
   @SequenceGenerator(
      name = "normal_mem_seq",
      sequenceName = "normal_mem_seq",
      allocationSize = 1
   )
   Integer nnum;

   @ManyToOne()
   @JoinColumn(
      name = "normalId",
      referencedColumnName = "id"
   )
   private MemberVO member;
   private double weight;
   private double height;
   private int purpose;
   private int activity;
   private String nickname;
   private double target_weight;
   private String NM_PROFILEIMG;
   private String REGION;

   public String getMemberName() {
      return this.member != null ? this.member.getName() : null;
   }

   public String getMemberId() {
      return this.member != null ? this.member.getId() : null;
   }
}