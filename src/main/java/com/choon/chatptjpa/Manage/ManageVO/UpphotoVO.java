package com.choon.chatptjpa.Manage.ManageVO;

import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "upphoto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpphotoVO 
{
    @Id
    @GeneratedValue(
       strategy = GenerationType.SEQUENCE,
       generator = "UPPHOTO_SEQ"
    )
    @SequenceGenerator(
    name = "UPPHOTO_SEQ",     
    sequenceName = "UPPHOTO_SEQ",  
    allocationSize = 1)
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
