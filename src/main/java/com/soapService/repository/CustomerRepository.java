package com.soapService.repository;

import com.soapService.model.Customer;
import com.soapService.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;


public class CustomerRepository {
    private List<Customer> customers;
    //@Autowired
    private OrderRepository orderRepository;

    public void initData() {
        customers = new ArrayList<>();

        Customer customer1 = new Customer();
        customer1.setName("John");
        customer1.setId(1);
        customer1.setRole(Role.ADMIN);

        customers.add(customer1);

        Customer customer2 = new Customer();
        customer2.setName("Anna");
        customer2.setId(2);
        customer2.setRole(Role.USER);

        customers.add(customer2);

        Customer customer3 = new Customer();
        customer3.setName("Allan");
        customer3.setRole(Role.USER);

        customers.add(customer3);
    }

    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Customer getCustomerById(int id) {
        for (Customer customer : customers) {
            if(customer.getId() == id){
                customer.setOrder(orderRepository.getOrderByCustomer(customer));
                return customer;
            }
        }
        return null;
    }

    public Customer updateCustomer(int id,Customer newCustomer) {
        for (Customer customer : customers) {
            if(customer.getId() == id){
                customer.setId(newCustomer.getId());
                customer.setName(newCustomer.getName());
                customer.setOrder(newCustomer.getOrder());
                return customer;
            }
        }
        return null;
    }




}
