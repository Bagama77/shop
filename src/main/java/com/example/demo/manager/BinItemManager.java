package com.example.demo.manager;

import com.example.demo.entity.BinItem;
import com.example.demo.repositories.BinItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.logging.Logger;

@Component
public class BinItemManager {
    @Autowired
    BinItemRepository binItemRepository;

    @Transactional
    public BinItem addBinItem(@NotNull @Valid BinItem binItem){
        BinItem binItem1 = null;
        try {
            binItem1 = binItemRepository.save(binItem);
            Logger.getLogger("BinItemManager").info("Added binItem: " + binItem1);
        } catch (PersistenceException ex){
            Logger.getLogger("BinItemManager").info("Can add binItem: " + binItem);
        }
        return binItem1;
    }

    @Transactional
    public BinItem updateBinItem(@NotNull @Valid BinItem binItem){
        BinItem binItem1 = null;
        try {
            binItem1 = binItemRepository.save(binItem);
            Logger.getLogger("BinItemManager").info("Updated binItem: " + binItem1);
        } catch (PersistenceException ex){
            Logger.getLogger("BinItemManager").info("Cannot update binItem: " + ex.getMessage());
        }
        return binItem1;
    }

    @Transactional
    public Set<BinItem> getAllBinItems(){
        Set<BinItem> binItems = null;
        try {
            binItems = (Set<BinItem>) binItemRepository.findAll();
            Logger.getLogger("BinItemManager").info("Found binItems: " + binItems);
        } catch (PersistenceException ex){
            Logger.getLogger("BinItemManager").info("Cannot find binItems: " + ex.getMessage());
        }
        return binItems;
    }

    @Transactional
    public boolean deleteBinItem(@NotNull long id){
        boolean ret = false;
        try {
            binItemRepository.deleteById(id);
            ret = true;
            Logger.getLogger("BinItemManager").info("Deleted binItem: " + id);
        } catch (PersistenceException ex){
            Logger.getLogger("BinItemManager").info("Cannot delete binItem: " + ex.getMessage());
        }
        return ret;
    }

    @Transactional
    public BinItem getByIdBinItem(@NotNull long id){
        BinItem ret = null;
        try {
            ret = binItemRepository.findById(id).orElseThrow();
            Logger.getLogger("BinItemManager").info("Found binItem: " + ret);
        } catch (NoSuchElementException ex){
            Logger.getLogger("BinItemManager").info("Cannot get binItem: " + ex.getMessage());
        }
        return ret;
    }
}
