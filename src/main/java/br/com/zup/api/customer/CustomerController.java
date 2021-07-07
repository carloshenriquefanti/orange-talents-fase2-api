package br.com.zup.api.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import br.com.zup.api.exceptions.CustomerNotFoundException;

@RestController
@RequestMapping("/customers")
public class CustomerController {


    @Autowired
    private CustomerService customerService;

    @GetMapping("/{id}")
    public CustomerEntity getcustomerById(@PathVariable("id") Integer id) throws CustomerNotFoundException {
        return customerService.getCustomerById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerEntity savecustomer(@RequestBody CustomerEntity customer) {
        return customerService.saveCustomer(customer);
    }
}
