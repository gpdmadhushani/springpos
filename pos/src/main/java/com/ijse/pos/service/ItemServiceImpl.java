package com.ijse.pos.service;

import java.util.List;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ijse.pos.dto.ItemDto;
import com.ijse.pos.entity.Item;
import com.ijse.pos.entity.ItemCategory;
import com.ijse.pos.repository.ItemCategoryRepository;
import com.ijse.pos.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ItemCategoryRepository categoryRepository;
   
    @Override
    public List<Item> getAllItems() {
       return itemRepository.findAll();
    }

    @Override
    public Item findItemById(Long id) {
       return itemRepository.findById(id).orElse(null);
       
    }

    

    @Override
    public Item updateItem(Long id, Item item) {
        Item existingItem=itemRepository.findById(id).orElse(null);
      
        if(existingItem!=null){
         existingItem.setName(item.getName());
         existingItem.setPrice(item.getPrice());
        // existingItem.setQuentity(item.getQuentity());
        existingItem.setDescription(item.getDescription());
        existingItem.setCategory_id(item.getCategory_id());
        
        // existingItem.setImage(item.getImage());
         
         return itemRepository.save(existingItem);
        }else{
         return null;
        }


       




    }

    @Override
    public Item createItem(Item item) {
        return itemRepository.save(item);
      }
       
    

    @Override
    public void deleteItem(Long id) {
         Item item = itemRepository.findById(id).orElse(null);
            
    itemRepository.delete(item);

    


    }

   @Override
   public List<Item> getItemsByCategory(Long id) {
      ItemCategory category=categoryRepository.findById(id).orElse(null);
       if(category!=null){
        return itemRepository.findItemByCategory(category);
       
       }else{
        return null;
       }

   }


    

    
    
    
}
