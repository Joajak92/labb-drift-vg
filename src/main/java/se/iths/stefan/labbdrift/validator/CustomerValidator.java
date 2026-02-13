package se.iths.stefan.labbdrift.validator;

import org.springframework.stereotype.Component;
import se.iths.stefan.labbdrift.exception.InvalidCustomerEmailException;
import se.iths.stefan.labbdrift.exception.InvalidCustomerFirstNameException;
import se.iths.stefan.labbdrift.exception.InvalidCustomerLastNameException;

@Component
public class CustomerValidator {

    public void validateCustomerFirstName(String firstName) {
        if (firstName == null || firstName.isEmpty()) {
            throw new InvalidCustomerFirstNameException("First name can not be empty");
        }
    }

    public void validateCustomerLastName(String lastName) {
        if (lastName == null || lastName.isEmpty()) {
            throw new InvalidCustomerLastNameException("Last name can not be empty");
        }
    }

    public void validateCustomerEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new InvalidCustomerEmailException("Email can not be empty");
        }
    }
}
