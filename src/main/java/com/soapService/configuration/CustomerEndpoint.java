package com.soapService.configuration;

import com.soapService.model.*;
import com.soapService.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CustomerEndpoint {
    private static final String NAMESPACE_URI = "http://tutorialspoint/schemas";
    private CustomerRepository customerRepository;


    @Autowired
    public CustomerEndpoint(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCustomerRequest")
    @ResponsePayload
    public GetCustomerResponse getCustomer(@RequestPayload GetCustomerRequest request) {
        Customer customer = customerRepository.getCustomerById(request.getCustomerId());
        GetCustomerResponse response = new GetCustomerResponse();
        response.setCustomer(customer);
        return response;

    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateCustomerRequest")
    @ResponsePayload
    public UpdateCustomerResponse updateCustomer(@RequestPayload UpdateCustomerRequest request) {
        Customer customer = customerRepository.updateCustomer(request.getCustomer().getId(), request.getCustomer());
        UpdateCustomerResponse response = new UpdateCustomerResponse();
        response.setCustomer(customer);
        return response;

    }
}
