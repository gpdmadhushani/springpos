package com.ijse.pos.entity;

import java.io.File;
import java.sql.Blob;
import java.util.Locale.Category;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
public class Item {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;  
     @Column(nullable = false)
    private String name;
    
    
    @Column
    private Double price;


@Column
    private Long stockid;
    @Column
    private String description;

   // @Column
   // private int quentity;

   // @Column
    //private String category;

    @ManyToOne(cascade = CascadeType.DETACH)
@JoinColumn(name = "category_id")
private ItemCategory category_id;

   // @Lob
    
   // @Column

    //private Blob image;

  // private File image;
    
}
