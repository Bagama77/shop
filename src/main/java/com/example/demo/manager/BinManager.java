package com.example.demo.manager;

import com.example.demo.entity.Bin;
import com.example.demo.repositories.BinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Set;
import java.util.logging.Logger;

@Component
public class BinManager {
    @Autowired
    BinRepository binRepository;

    @Transactional
    public Bin addBin(@NotNull @Valid Bin bin){
        Bin ret = null;
        try{
            ret = binRepository.save(bin);
            Logger.getLogger("BinManager").info("Added bin: " + ret);
        } catch (PersistenceException exception){
            Logger.getLogger("BinManager").info(exception.getMessage());
        }
        return ret;
    }

    @Transactional
    public Set<Bin> getAllBins(){
        Set<Bin> ret = null;
        try {
            ret = (Set<Bin>) binRepository.findAll();
            Logger.getLogger("BinManager").info(" found bins: " + ret);
        } catch (NoResultException ex){
            Logger.getLogger("BinManager").info("not found bins: " + ex.getMessage());
        }
        return ret;
    }

    @Transactional
    public Bin getById(@NotNull long id){
        Bin ret = null;
        try{
            ret = binRepository.findById(id).orElseThrow();
        } catch (Exception ex) {
            Logger.getLogger("BinManager").info("not found bin by id: " + id);
        }
        return ret;
    }

    @Transactional
    public Bin updateBin(@NotNull @Valid Bin bin){
        Bin ret = null;
        try{
            ret = binRepository.save(bin);
            Logger.getLogger("BinManager").info("saved updated bin: " + bin);
        } catch (PersistenceException ex){
            Logger.getLogger("BinManager").info("not saved updated bin: " + bin);
        }
        return ret;
    }

    @Transactional
    public boolean deleteBin(@NotNull long id){
        boolean ret = false;
        try{
            binRepository.deleteById(id);
            ret = true;
        } catch (Exception ex) {
            Logger.getLogger("BinManager").info("not found bin by id: " + id);
        }
        return ret;
    }
}
