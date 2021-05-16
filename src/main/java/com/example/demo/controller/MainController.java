package com.example.demo.controller;

import com.example.demo.entity.Bin;
import com.example.demo.entity.BinItem;
import com.example.demo.entity.Item;
import com.example.demo.entity.User;
import com.example.demo.manager.ItemManager;
import com.example.demo.manager.UserManager;
import com.example.demo.repositories.BinItemRepository;
import com.example.demo.repositories.BinRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/shop")
public class MainController {

    @Autowired
    ItemManager itemManager;

    @Autowired
    UserManager userManager;

    @Autowired
    BinItemRepository binItemRepository;

    @Autowired
    BinRepository binRepository;


    @GetMapping("/home")
    public String helloShop(Model model) {
        List<Item> items = itemManager.getAll();

        model.addAttribute("items", items);
        model.addAttribute("quantity", items.size());

        return "home2";
    }

    @PostMapping(path = "/user/add")
    public @ResponseBody User addNewPerson(@RequestBody User user) {
        userManager.addUser(user);
        return user;
    }

    @GetMapping(path = "/users/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userManager.getAllUsers();
    }

    @PostMapping(path = "/bin/add{userid}")
    public @ResponseBody Bin addNewBin(@RequestParam("userid") long userId) {
        Bin bin = new Bin();
        bin.setUser(userManager.getUserById(userId));
        binRepository.save(bin);
        return bin;
    }

    @PostMapping(path = "/item/add")
    public @ResponseBody Item addNewItem(@RequestBody Item item) {
        itemManager.addItem(item);
        return item;
    }

    @PostMapping(path = "/tobin/add/{binid}{itemid}{quantity}")
    public @ResponseBody BinItem addItemToBin(@RequestParam("itemid") long itemId,
                         @RequestParam("binid") long binId,
                         @RequestParam("quantity") int quantity) {
        BinItem binItem = new BinItem();
        binItem.setQuantity(quantity);
        binItem.setItemId(itemId);

        Bin bin = binRepository.findById(binId).orElseThrow();
        List<BinItem> binItems = bin.getBinItems();
        binItems.add(binItem);
        bin.setBinItems(binItems);
        binRepository.save(bin);

        return binItem;
    }

    @GetMapping(path = "/bins{binid}")
    public @ResponseBody Bin getBin(@NotNull @RequestParam("binid") long binId) {
        Bin bin = binRepository.findById(binId).get();
        return bin;
    }

}
