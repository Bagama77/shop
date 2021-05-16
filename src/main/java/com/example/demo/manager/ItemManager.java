package com.example.demo.manager;

import com.example.demo.entity.Item;
import com.example.demo.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

@Component
public class ItemManager {

    @Autowired
    ItemRepository itemRepository;

    @Transactional
    public List<Item> getAll() {
        List<Item> items = null;
        try {
            items = (List<Item>) itemRepository.findAll();
            Logger.getLogger("ItemManager").info("Found items: " + items);
        } catch (NoSuchElementException ex) {
            Logger.getLogger("ItemManager").info("Can not find all items: " + ex.getMessage());
        }
        return items;
    }

    @Transactional
    public Item addItem(@NotNull @Valid Item item) {
        Item ret = null;
        try {
            ret = itemRepository.save(item);
            Logger.getLogger("ItemManager").info("Saved item: " + ret);
        } catch (PersistenceException ex) {
            Logger.getLogger("ItemManager").info("Can not save item: " + ex.getMessage());
        }
        return ret;
    }

    @Transactional
    public Item updateItem(@NotNull @Valid Item item) {
        Item ret = null;
        try {
            ret = itemRepository.save(item);
            Logger.getLogger("ItemManager").info("Updated item: " + ret);
        } catch (PersistenceException ex) {
            Logger.getLogger("ItemManager").info("Can not save item: " + ex.getMessage());
        }
        return null;
    }

    @Transactional
    public boolean deleteItem(@NotNull long id){
        try {
            itemRepository.deleteById(id);
            if(itemRepository.findById(id).isEmpty()) {
                Logger.getLogger("ItemManager").info("Deleted item: " + id);
                return true;
            }
        } catch (PersistenceException ex) {
            Logger.getLogger("ItemManager").info("Can not delete item: " + ex.getMessage());
        }
        return false;
    }

    @Transactional
    public Item getItemById(@NotNull long id){
        Item item = null;
        try {
            item = itemRepository.findById(id).orElseThrow();
                Logger.getLogger("ItemManager").info("Get item: " + item);
        } catch (NoSuchElementException ex) {
            Logger.getLogger("ItemManager").info("Can not found item: " + ex.getMessage());
        }
        return item;
    }
}
