package com.choon.chatptjpa.Manage.ManageVO;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(
   name = "imgediterequest"
)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ImgEditRequestVO {
    @Id
    @GeneratedValue(
       strategy = GenerationType.SEQUENCE,
       generator = "eidtrequest_seq"
    )
    @SequenceGenerator(
       name = "eidtrequest_seq",
       sequenceName = "eidtrequest_seq",
       allocationSize = 1
    )
    private Long edit_request_id;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "upphotoid" , referencedColumnName = "upphotoid")
    private UpphotoVO upphotoid;


    private String img_editcomment;
    private String img_edit;
    @Column(
       columnDefinition = "NUMBER(1) DEFAULT 0"
    )
    private Integer edit_request_status;
    private String before_data;
    private String after_data;


    public int getFoodNum()
    {
      return upphotoid.getFoodnum();
    }

    public Long getUpphotoId()
    {
      return upphotoid.getUpphotoid();
    }
}