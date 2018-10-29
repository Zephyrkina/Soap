package com.soapService.repository;

import com.soapService.model.Customer;
import com.soapService.model.Order;

import java.util.*;

public class OrderRepository {
    private static final List<Order> orders = new ArrayList<>();

    public void initData() {
        Order order = new Order();
        order.setId(1);
        order.setName("banana");
        order.setCustomerId(1);
        order.setAmount(4);
        orders.add(order);

        Order order2 = new Order();
        order2.setId(2);
        order2.setName("apple");
        order2.setCustomerId(1);
        order2.setAmount(34);
        orders.add(order2);

        Order order3 = new Order();
        order3.setId(3);
        order3.setName("banana4");
        order3.setCustomerId(2);
        order3.setAmount(45);
        orders.add(order3);

        Order order4 = new Order();
        order4.setId(4);
        order4.setName("banana5");
        order4.setCustomerId(2);
        order4.setAmount(44);
        orders.add(order4);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public Order getOrderByCustomer(Customer customer) {
        for (Order order : orders){
            if(order.getCustomerId() == customer.getId()){
                return order;
            }
        }
        return null;
    }
}
