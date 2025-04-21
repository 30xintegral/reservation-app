package com.demo.reservationapp.service.impl;

import com.demo.reservationapp.dtos.request.CustomerRequest;
import com.demo.reservationapp.dtos.response.CustomerResponse;
import com.demo.reservationapp.dtos.response.ReservationResponse;
import com.demo.reservationapp.entity.Customer;
import com.demo.reservationapp.entity.User;
import com.demo.reservationapp.entity.UserPrincipal;
import com.demo.reservationapp.exceptions.NotFoundException;
import com.demo.reservationapp.mapper.CustomerMapper;
import com.demo.reservationapp.repository.CustomerRepository;
import com.demo.reservationapp.service.CustomerService;
import com.demo.reservationapp.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ReservationService reservationService;

    @Override
    public void save(CustomerRequest customerRequest) {
        Customer customer = CustomerMapper.INSTANCE.requestToEntity(customerRequest);
        customer.setRegisteredAt(LocalDateTime.now());
        customer.setUpdatedAt(LocalDateTime.now());

        UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userPrincipal.getUser();
        customer.setUser(user);
        customerRepository.save(customer);
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void updateCustomerById(Long id, CustomerRequest customerRequest) {

    }

    @Override
    public void deleteCustomerById(Long id) {

    }

    @Override
    public CustomerResponse findCustomerById(Long id, int page, int size) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new NotFoundException("Customer data not found"));
        CustomerResponse customerResponse = CustomerMapper.INSTANCE.entityToResponse(customer);

        Set<ReservationResponse> reservationResponseSet = reservationService.findAllReservationsByCustomerId(id, page, size);

        customerResponse.setReservations(reservationResponseSet);

        return customerResponse;
    }

    @Override
    public List<CustomerResponse> findAllCustomers(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        List<Customer> customers = customerRepository.findAll(pageable).getContent();
        List<CustomerResponse> customerResponses = new ArrayList<>();
        for (Customer customer : customers) {
            CustomerResponse customerResponse = CustomerMapper.INSTANCE.entityToResponse(customer);
            customerResponses.add(customerResponse);
        }
        return customerResponses;
    }
}
