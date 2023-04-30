package ua.com.public_utilities_admin.service;
import org.springframework.stereotype.Service;
import ua.com.public_utilities_admin.entity.Customer;
import ua.com.public_utilities_admin.repository.CustomerRepository;


import org.springframework.stereotype.Service;

@Service
public class CustomerManagerService {
    private final CustomerRepository customerRepository;

    public CustomerManagerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void saveCustomerToDB(Customer customer){
        customerRepository.save(customer);
    }
}
