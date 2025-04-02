package com.demo.reservationapp.service;

import com.demo.reservationapp.dtos.request.CustomerRequest;
import com.demo.reservationapp.dtos.response.CustomerResponse;

import java.util.List;

public interface CustomerService {
    void save(CustomerRequest customerRequest);

    void deleteAll();

    void updateCustomerById(Long id, CustomerRequest customerRequest);

    void deleteCustomerById(Long id);

    CustomerResponse findCustomerById(Long id, int page, int size);

    List<CustomerResponse> findAllCustomers(int page, int size);
}
