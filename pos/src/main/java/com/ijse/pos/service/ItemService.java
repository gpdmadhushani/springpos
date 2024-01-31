package com.ijse.pos.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ijse.pos.dto.ItemDto;
import com.ijse.pos.entity.Item;
import com.ijse.pos.entity.ItemCategory;


@Service
public interface ItemService {
List<Item> getAllItems();
    Item findItemById(Long id);
    Item createItem(Item item);
    Item updateItem(Long id,Item item); 
   
    void deleteItem(Long id);
    List<Item> getItemsByCategory(Long id);


    
    
   
    
    





    
}
