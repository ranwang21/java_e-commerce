package com.bean;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author rwang
 *
 */
public class Cart {

    /**
     * cart's container map key:pid, value :CartItem
     */
    private Map<Integer, CartItem> map = new LinkedHashMap<Integer, CartItem>();

    /**
     * total amount
     */
    private float total;

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    /**
     * get the items from the cart
     */
    public Collection<CartItem> getCartItems() {
        return map.values();
    }

    /**
     * add product into cart
     */
    public void addCart(CartItem cartItem) {
        Integer pid = cartItem.getLivre().getId();
        //check if the same product exists in the cart
        if (map.containsKey(pid)) {
            CartItem _cartItem = map.get(pid);
            _cartItem.setCount(_cartItem.getCount() + cartItem.getCount());
        } else {
            map.put(pid, cartItem);
        }
        /**
         * calculate the subtotal
         */
        total += cartItem.getSubtotal();
    }

    /**
     * remove an item from the cart
     */
    public void removeCart(Integer pid) {
        CartItem cartItem = map.remove(pid);

        total -= cartItem.getSubtotal();
    }

    /**
     * clear the cart
     */
    public void clearCart() {
        map.clear();
        total = 0;
    }

}
