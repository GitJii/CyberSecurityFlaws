/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sec.project.domain;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 *
 * @author Jaakko-PC
 */

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ShoppingCart implements Serializable {

    private Map<Item, Long> itemCounts;

    public ShoppingCart() {
        this.itemCounts = new TreeMap<>();
    }

    public void addToCart(Item product) {
        long count = 1;

        if (itemCounts.containsKey(product)) {
            count += itemCounts.get(product);
        }

        itemCounts.put(product, count);
    }

    public void removeFromCart(Item product) {
        if (!itemCounts.containsKey(product)) {
            return;
        }

        long count = itemCounts.get(product);
        if (count <= 1) {
            itemCounts.remove(product);
        } else {
            itemCounts.put(product, count - 1);
        }
    }

    public Map<Item, Long> getItems() {
        return itemCounts;
    }

    public double getSum() {
        double sum = 0;
        for (Item item : itemCounts.keySet()) {
            sum += item.getPrice() * itemCounts.get(item);
        }

        return sum;
    }
}
