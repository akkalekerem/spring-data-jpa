package com.keremakkale.controller;

import com.keremakkale.dto.DtoCustomer;

public interface ICustomerController {

    public DtoCustomer findCustomerById(Long id);
}
