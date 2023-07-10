package com.rhanem.customerservice.web;

import com.rhanem.customerservice.CustomerServiceApplication;
import com.rhanem.customerservice.dto.CustomerRequest;
import com.rhanem.customerservice.entities.Customer;
import com.rhanem.customerservice.mapper.CustomerMapper;
import com.rhanem.customerservice.repository.CustomerRepository;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
@WebService(serviceName = "CustomerWS")
public class CustomerSoapService {

    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    @WebMethod
    public List<Customer> customersList(){
        return customerRepository.findAll();
    }

    @WebMethod
    public Customer customersById(@WebParam(name = "id") Long id){
        return  customerRepository.findById(id).get();
    }

    public Customer saveCustomer(@WebParam(name = "customer") CustomerRequest customer){
        return customerRepository.save(customerMapper.from(customer));
    }
}
