package com.ijse.pos.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



import com.ijse.pos.entity.ItemCategory;


@Repository
public interface ItemCategoryRepository extends JpaRepository<ItemCategory,Long> {
    public boolean findCategoryByname(String name);
}
