package com.ijse.pos.dto;

import java.io.File;
import java.sql.Blob;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class ItemDto {
    private String name;
    private Double price; 
    //private int quentity;
    private Long category_id;
    private Long stockid;
    private String description;
   // private Blob image;
   //private File image;
    
}
