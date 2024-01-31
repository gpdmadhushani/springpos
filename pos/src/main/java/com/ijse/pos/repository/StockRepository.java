package com.ijse.pos.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ijse.pos.entity.Item;
import com.ijse.pos.entity.ItemCategory;
import com.ijse.pos.entity.Stock;



@Repository
public interface StockRepository extends JpaRepository<Stock,Long> {
     @Query("SELECT p FROM Stock p WHERE p.category_id= :category_id")
     List <Stock> findStockByCategory(@Param("category_id") ItemCategory category_id);
    
}
