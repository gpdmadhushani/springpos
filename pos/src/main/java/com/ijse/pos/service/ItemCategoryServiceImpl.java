package com.ijse.pos.service;

import java.util.List;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.pos.entity.ItemCategory;
import com.ijse.pos.repository.ItemCategoryRepository;

@Service
public class ItemCategoryServiceImpl implements ItemCategoryService{

    @Autowired
    private ItemCategoryRepository itemCategoryRepository;

   
    @Override
    public List<ItemCategory> getAllCategories() {
        
        return itemCategoryRepository.findAll();
        
    }

    @Override
    public ItemCategory findCategoryById(Long id) {
        return itemCategoryRepository.findById(id).orElse(null);
    }

    @Override
    public boolean findCategoryByname(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findCategoryByname'");
    }

    @Override
    public ItemCategory createCategory(ItemCategory category) {
       return itemCategoryRepository.save(category);
    }

    @Override
    public ItemCategory updateCategory(Long id, ItemCategory category) {
       ItemCategory existingCategory=itemCategoryRepository.findById(id).orElse(null);
       if(existingCategory!=null){
        existingCategory.setName(category.getName());
        existingCategory.setDescription(category.getDescription());
        return itemCategoryRepository.save(existingCategory);
       }else{
        return null;
       }
    }

    @Override
    public void deleteCategory(Long id) {
       // itemCategoryRepository.deleteById(id);

        ItemCategory cates = itemCategoryRepository.findById(id).orElse(null);
            
    itemCategoryRepository.delete(cates);
    }

    


   

    
    

   

    

    
   
   
    

    
}
