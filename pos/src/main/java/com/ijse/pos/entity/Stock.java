package com.ijse.pos.entity;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
public class Stock {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;  
     @Column(nullable = false)
    private String name;
    
    
    @Column
    private Double price;

    @Column
    private String manufactered;

    @Column
    private String status;

    @Column
    private int quentity;

   @Column
    private String upadtetime; 
   

    @ManyToOne(cascade = CascadeType.DETACH)
@JoinColumn(name = "category_id")
private ItemCategory category_id;

   
}
