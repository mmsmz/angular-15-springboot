package com.springboot_crud.customerData.service;

import com.springboot_crud.customerData.dto.RequestCustomerDto;
import com.springboot_crud.customerData.entity.CustomerEntity;
import com.springboot_crud.customerData.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {


    @Autowired
    CustomerRepository customerRepository;

    @Override
    public String insertCustomerDetails(RequestCustomerDto requestCustomerDto) {

        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setName(requestCustomerDto.getName());
        customerEntity.setEmail(requestCustomerDto.getEmail());
        customerEntity.setPhone(requestCustomerDto.getPhone());


        Optional<CustomerEntity> saveData = Optional.of(customerRepository.save(customerEntity));
        if(saveData.isPresent()){
            return "Success";
        }
        else
            return "Failed";
    }

    @Override
    public List<CustomerEntity> getAllCustomerDetails() {
        List<CustomerEntity> all = customerRepository.findAll();
        return all;
    }
}
