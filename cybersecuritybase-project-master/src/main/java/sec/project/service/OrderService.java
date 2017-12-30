/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sec.project.service;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sec.project.domain.Item;
import sec.project.domain.Order;
import sec.project.domain.OrderItem;
import sec.project.domain.ShoppingCart;
import sec.project.repository.ItemRepository;
import sec.project.repository.OrderRepository;

/**
 *
 * @author Jaakko-PC
 */

@Service
public class OrderService {

    @Autowired
    private ShoppingCart shoppingCart;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> list() {
        return orderRepository.findAll();
    }

    @Transactional
    public void placeOrder(String name, String address) {

        Order order = new Order();
        order.setName(name);
        order.setAddress(address);

        List<OrderItem> items = new ArrayList<>();
        for (Item item : shoppingCart.getItems().keySet()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setItem(itemRepository.findOne(item.getId()));
            orderItem.setItemCount(shoppingCart.getItems().get(item));

            items.add(orderItem);
        }

        order.setOrderItems(items);

        orderRepository.save(order);
        shoppingCart.getItems().clear();
    }
}
