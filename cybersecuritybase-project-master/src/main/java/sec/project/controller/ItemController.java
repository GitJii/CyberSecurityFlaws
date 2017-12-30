/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sec.project.controller;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sec.project.domain.Item;
import sec.project.repository.ItemRepository;

/**
 *
 * @author Jaakko-PC
 */

@Controller
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @PostConstruct
    public void init() {
        // add some content to the product repository
        itemRepository.save(new Item("XSS-attack", 200.0));
        itemRepository.save(new Item("Injection-attack", 100.0));
        itemRepository.save(new Item("Broken authentication", 1200.0));
        itemRepository.save(new Item("Security misconfiguration", 50.0));
        itemRepository.save(new Item("Using components with known vulnerabilities", 1000.0));
        itemRepository.save(new Item("Missing function level access control", 1400.0));
        itemRepository.save(new Item("Sensitive data exposure", 1.0));
        
    }

    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("items", itemRepository.findAll());
        return "items";
    }
    
    @PostMapping(value="/items")
    public String addItem(@RequestParam String name, Double price){
        Item item = new Item();
        item.setName(name);
        item.setPrice(price);
        this.itemRepository.save(item);
        
        return "items";
    }
}

