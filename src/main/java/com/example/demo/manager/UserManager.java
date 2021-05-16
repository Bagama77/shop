package com.example.demo.manager;

import com.example.demo.entity.User;
import com.example.demo.repositories.UserRepository;
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
public class UserManager {
    @Autowired
    UserRepository userRepository;

    @Transactional
    public User addUser(@NotNull @Valid User user){
        User ret = null;
        try {
            ret = userRepository.save(user);
            Logger.getLogger("UserManager").info("User is added: " + ret);
        }catch (PersistenceException ex){
            Logger.getLogger("UserManager").info("User not added: " + user + " exception:" +
                    ex.getMessage());
        }
        return ret;
    }

    @Transactional
    public User updateUser(@NotNull @Valid User user){
        User ret = null;
        try {
            ret = userRepository.save(user);
            Logger.getLogger("UserManager").info("User is updated: " + ret);
        }catch (PersistenceException ex){
            Logger.getLogger("UserManager").info("User is not updated: " + user + " exception:" +
                    ex.getMessage());
        }
        return ret;
    }

    @Transactional
    public User getUserById(@NotNull long id){
        User ret = null;
        try {
            ret = userRepository.findById(id).orElseThrow();
            Logger.getLogger("UserManager").info("User is found: " + ret);
        }catch (NoSuchElementException ex){
            Logger.getLogger("UserManager").info("User not found with id: " + id + " exception:" +
                    ex.getMessage());
        }
        return ret;
    }

    @Transactional
    public Set<User> getAllUsers(){
        Set<User> ret = null;
        try {
            ret = (Set<User>)userRepository.findAll();
            Logger.getLogger("UserManager").info("Users are found: " + ret);
        }catch (NoSuchElementException ex){
            Logger.getLogger("UserManager").info("Users are not found exception:" +
                    ex.getMessage());
        }
        return ret;
    }

    @Transactional
    public boolean deleteUser(@NotNull long id){
        try {
            userRepository.deleteById(id);
            Logger.getLogger("UserManager").info("User is deleted: " + id);
            return true;
        }catch (NoSuchElementException ex){
            Logger.getLogger("UserManager").info("User is not deleted with id: " + id + " exception:" +
                    ex.getMessage());
        }
        return false;
    }
}
