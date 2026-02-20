package se.iths.stefan.labbdriftvg.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import se.iths.stefan.labbdriftvg.exception.CustomerNotFoundException;
import se.iths.stefan.labbdriftvg.model.Customer;
import se.iths.stefan.labbdriftvg.repository.CustomerRepository;
import se.iths.stefan.labbdriftvg.validator.CustomerValidator;

import java.util.List;

@Service
public class CustomerService {
    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);
    private final CustomerRepository customerRepository;
    private final CustomerValidator customerValidator;

    public CustomerService(CustomerRepository customerRepository, CustomerValidator customerValidator) {
        this.customerRepository = customerRepository;
        this.customerValidator = customerValidator;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomer(Long id) {
        logger.info("Getting customer with id: " + id);
        return customerRepository.findById(id)
                .orElseThrow(() -> {
                    logger.error("Customer with id: " + id + " not found");
                    return new CustomerNotFoundException("No such customer id: " + id);
                });
    }

    public Customer createCustomer(Customer customer) {
        customerValidator.validateCustomerFirstName(customer.getFirstName());
        customerValidator.validateCustomerLastName(customer.getLastName());
        customerValidator.validateCustomerEmail(customer.getEmail());
        return customerRepository.save(customer);
    }

    public void deleteCustomer(Long id) {
        customerRepository.findById(id)
                .orElseThrow(() -> {
                    logger.error("Cannot delete, customer with id: " + id + " not found");
                    return new CustomerNotFoundException("Customer with id: " + id + " not found");
                });
        logger.info("Deleting customer with id: " + id);
        customerRepository.deleteById(id);
    }

    public Customer updateCustomer(Long id, Customer customer) {
        customerRepository.findById(id)
                .orElseThrow(() -> {
                    logger.error("Cannot update, customer with id: " + id + " not found");
                    return new CustomerNotFoundException("Customer with id : " + id + " not found");
                });
        logger.info("Updating customer with id: " + id);
        customerValidator.validateCustomerFirstName(customer.getFirstName());
        customerValidator.validateCustomerLastName(customer.getLastName());
        customerValidator.validateCustomerEmail(customer.getEmail());
        customer.setId(id);
        return customerRepository.save(customer);
    }
}