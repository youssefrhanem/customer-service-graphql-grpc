package com.rhanem.customerservice.mapper;

import com.rhanem.customerservice.dto.CustomerRequest;
import com.rhanem.customerservice.entities.Customer;
import com.rhanem.customerservice.stub.CustomerServiceOuterClass;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    private final ModelMapper modelMapper = new ModelMapper();


    public Customer from(CustomerRequest customerRequest){
        // Customer customer = new Customer();
//        customer.setName(customerRequest.name());
//        customer.setEmail(customerRequest.email());
        return modelMapper.map(customerRequest,Customer.class);
    }

    public CustomerServiceOuterClass.Customer fromCustomer(Customer customer) {
        return modelMapper.map(customer, CustomerServiceOuterClass.Customer.Builder.class).build();
    }

    public Customer fromGrpcCustomerRequest(CustomerServiceOuterClass.CustomerRequest customerRequest) {
        return modelMapper.map(customerRequest, Customer.class);
    }

}
