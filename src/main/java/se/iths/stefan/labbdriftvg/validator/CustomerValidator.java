package se.iths.stefan.labbdriftvg.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import se.iths.stefan.labbdriftvg.exception.CustomerNotFoundException;

@Component
public class CustomerValidator {
    private static final Logger logger = LoggerFactory.getLogger(CustomerValidator.class);

    public void validateCustomerFirstName(String firstName) {
        if (firstName == null || firstName.isBlank()) {
            logger.error("Validation failed: firstName is null or empty");
            throw new CustomerNotFoundException("First name can not be empty");
        }
    }

    public void validateCustomerLastName(String lastName) {
        if (lastName == null || lastName.isBlank()) {
            logger.error("Validation failed: lastName is null or empty");
            throw new CustomerNotFoundException("Last name can not be empty");
        }
    }

    public void validateCustomerEmail(String email) {
        if (email == null || email.isBlank()) {
            logger.error("Validation failed: email is null or empty");
            throw new CustomerNotFoundException("Email can not be empty");
        }
    }
}
