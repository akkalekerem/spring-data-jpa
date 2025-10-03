package com.keremakkale.services;

import com.keremakkale.dto.DtoCustomer;

public interface ICustomerService {

    public DtoCustomer findCustomerById(Long id);

}
