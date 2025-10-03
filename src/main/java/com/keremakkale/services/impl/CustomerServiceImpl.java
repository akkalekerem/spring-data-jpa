package com.keremakkale.services.impl;

import com.keremakkale.dto.DtoAddress;
import com.keremakkale.dto.DtoCustomer;
import com.keremakkale.entities.Address;
import com.keremakkale.entities.Customer;
import com.keremakkale.repository.CustomerRepository;
import com.keremakkale.services.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public DtoCustomer findCustomerById(Long id) {

        DtoCustomer dtoCustomer = new DtoCustomer();
        DtoAddress dtoAddress = new DtoAddress();

        Optional<Customer> optional = customerRepository.findById(id);  //Burası Önemli
        if(optional.isEmpty()){
            return null;
        }
        Customer customer = optional.get();
        Address address = optional.get().getAddress();

        BeanUtils.copyProperties(customer, dtoCustomer);
        BeanUtils.copyProperties(address, dtoAddress);

        dtoCustomer.setAddress(dtoAddress);
        return dtoCustomer;
    }
}
