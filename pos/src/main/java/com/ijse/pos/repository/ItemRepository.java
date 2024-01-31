package com.ijse.pos.repository;



import java.util.List;
import java.util.Locale.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ijse.pos.entity.Item;
import com.ijse.pos.entity.ItemCategory;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {
   //  @Query("SELECT p FROM Item p WHERE p.category= :category")
    // List <Item> findItemByCategory(@Param("itemCategory") ItemCategory category);

     @Query("SELECT p FROM Item p WHERE p.category_id= :category_id")
     List <Item> findItemByCategory(@Param("category_id") ItemCategory category_id);

}
