/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sec.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sec.project.domain.ShoppingCart;
import sec.project.repository.ItemRepository;
/**
 *
 * @author Jaakko-PC
 */


@Controller
public class CartController {

    @Autowired
    private ShoppingCart shoppingCart;

    @Autowired
    private ItemRepository itemRepository;

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("items", shoppingCart.getItems());
        model.addAttribute("sum", shoppingCart.getSum());
        return "cart";
    }

    @RequestMapping(value = "/cart/items/{itemId}", method = RequestMethod.POST)
    public String add(@PathVariable Long itemId) {
        shoppingCart.addToCart(itemRepository.findOne(itemId));
        return "redirect:/cart";
    }

    @RequestMapping(value = "/cart/items/{itemId}", method = RequestMethod.DELETE)
    public String remove(@PathVariable Long itemId) {
        shoppingCart.removeFromCart(itemRepository.findOne(itemId));
        return "redirect:/cart";
    }
}
