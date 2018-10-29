package com.soapService.repository;

import com.soapService.model.Currency;
import com.soapService.model.Customer;
import com.soapService.model.Role;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;



public class CustomerRepository {
    private static final Map<Integer, Customer> customers = new HashMap<>();

    public void initData() {
        Customer customer1 = new Customer();
        customer1.setName("John");
        customer1.setId(1);
        customer1.setRole(Role.ADMIN);

        customers.put(customer1.getId(), customer1);

        Customer customer2 = new Customer();
        customer2.setName("Anna");
        customer2.setId(2);
        customer2.setRole(Role.USER);

        customers.put(customer2.getId(), customer2);

        Customer customer3 = new Customer();
        customer3.setName("Allan");
        customer3.setId(3);
        customer3.setRole(Role.USER);

        customers.put(customer3.getId(), customer3);

    }

    public Customer findCustomer(Integer id) {
        Assert.notNull(id, "The customer's is must not be null");
        return customers.get(id);
    }
}
