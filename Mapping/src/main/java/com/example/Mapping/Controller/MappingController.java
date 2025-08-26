package com.example.Mapping.Controller;

import com.example.Mapping.Entity.Customer;
import com.example.Mapping.Repository.CustomerRepository;
import com.example.Mapping.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class MappingController {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ItemRepository itemRepository;
    @PostMapping("/")
    public Customer save(@RequestBody Customer customer)
    {
        return customerRepository.save(customer);
    }

}
