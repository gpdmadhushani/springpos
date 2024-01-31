package com.ijse.pos.dto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data

public class StockDto {
    private String name;
    private Double price; 
    private int quentity;
    private String manufacterd;
    private String status;
    private Long category_id;
   
}
