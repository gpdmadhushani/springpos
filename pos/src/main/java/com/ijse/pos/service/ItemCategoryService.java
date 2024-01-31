package com.ijse.pos.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.ijse.pos.entity.ItemCategory;

@Service
public interface ItemCategoryService {
   List<ItemCategory> getAllCategories();
    ItemCategory findCategoryById(Long id);
    void deleteCategory(Long id);
    boolean findCategoryByname(String name);
    ItemCategory createCategory(ItemCategory category);
    ItemCategory updateCategory(Long id,ItemCategory category); 
    
}
