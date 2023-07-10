package com.rhanem.customerservice.config;

import com.rhanem.customerservice.web.CustomerSoapService;
import jakarta.xml.ws.Endpoint;
import lombok.AllArgsConstructor;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class CXFSoapWebServiceConfig {


    private Bus bus;
    private CustomerSoapService customerSoapService;

    //http://localhost:8082/services/CustomerService?wsdl
    //http://localhost:8082/services/CustomerService
    @Bean
    public Endpoint endpoint(){
        EndpointImpl endpoint = new EndpointImpl(bus, customerSoapService);
        endpoint.publish("/CustomerService");
        return endpoint;
    }

}
