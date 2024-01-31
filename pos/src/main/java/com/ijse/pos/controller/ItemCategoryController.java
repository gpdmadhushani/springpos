package com.ijse.pos.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.ijse.pos.entity.ItemCategory;
import com.ijse.pos.service.ItemCategoryService;

@RestController
 @CrossOrigin(origins="*")

public class ItemCategoryController {
    @Autowired
    private ItemCategoryService itemCategoryService;

   



    @GetMapping("/categories")

     public List<ItemCategory> getAllCategories(){
        
        return itemCategoryService.getAllCategories();
    }

    
    @PostMapping("/categories")

    public ItemCategory creaCategory(@RequestBody ItemCategory category){
        return itemCategoryService.createCategory(category);
    }

      @GetMapping("/categories/{id}")

      public ItemCategory getCategoryById(@PathVariable Long id){
     return itemCategoryService.findCategoryById(id);
     
    } 

    



     @PutMapping("/categories/{id}")

    public ItemCategory updateCategory(@PathVariable Long id, @RequestBody ItemCategory category){
        return itemCategoryService.updateCategory(id, category);

    }
  
    @DeleteMapping("/deletecategoriess/{id}")
    
  
    public void deleteCategory(@PathVariable("id") Long id){
        itemCategoryService.deleteCategory(id);
    }
    
   
   
    
}
