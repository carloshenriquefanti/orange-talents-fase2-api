package br.com.zup.api.customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.api.exceptions.CustomerNotFoundException;
import br.com.zup.api.customer.CustomerEntity;
import br.com.zup.api.customer.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerEntity getCustomerById(Integer id) throws CustomerNotFoundException {
        return customerRepository.findById(id).orElseThrow(CustomerNotFoundException::new);
    }

    public CustomerEntity saveCustomer(CustomerEntity customer) {
        return customerRepository.save(customer);
    }
}
