package se.iths.stefan.labbdriftvg;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import se.iths.stefan.labbdriftvg.model.Customer;
import se.iths.stefan.labbdriftvg.repository.CustomerRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class CustomerControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private CustomerRepository customerRepository;

    @BeforeEach
    public void setUp() {
        customerRepository.deleteAll();
    }

    @Test
    public void testCreateCustomerVerifySave() throws Exception {
        mockMvc.perform(post("/customers")
                .param("firstName", "Jan")
                .param("lastName", "Jansson")
                .param("email", "Jan.Jansson@email.com"));

        Customer savedCustomer = customerRepository.findByEmail("Jan.Jansson@email.com")
                .orElseThrow();

        assertEquals("Jan", savedCustomer.getFirstName());
        assertEquals("Jansson", savedCustomer.getLastName());
    }

    @Test
    public void testCreateCustomerVerify() throws Exception {
        Customer customer = new Customer();
        customer.setFirstName("Per");
        customer.setLastName("Persson");
        customer.setEmail("Per.Persson@email.com");
        customerRepository.save(customer);

        mockMvc.perform(get("/customers/" + customer.getId()))
                .andExpect(model().attributeExists("customer"));
    }

    @Test
    public void testGetAllCustomersVerifyCount() throws Exception {
        Customer customer = new Customer();
        customer.setFirstName("Jan");
        customer.setLastName("Jansson");
        customer.setEmail("Jan.Jansson@email.com");
        customerRepository.save(customer);

        Customer customer2 = new Customer();
        customer2.setFirstName("Per");
        customer2.setLastName("Persson");
        customer2.setEmail("Per.Persson@email.com");
        customerRepository.save(customer2);

        mockMvc.perform(get("/customers"))
                .andExpect(model().attribute("customers", org.hamcrest.Matchers.hasSize(2)));
    }
}