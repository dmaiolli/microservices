package br.com.denys.customer;

import br.com.denys.clients.fraud.FraudCheckResponse;
import br.com.denys.clients.fraud.FraudClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;
    private final FraudClient fraudClient;

    public void registerCustomer(CustomerRegistrationRequest customerRequest) {
        Customer customer = Customer.builder()
                .firstName(customerRequest.firstName())
                .lastname(customerRequest.lastName())
                .email(customerRequest.email())
                .build();

        // todo: check if email valid
        // todo: check if email not taken

        customerRepository.saveAndFlush(customer);

        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        if(Boolean.TRUE.equals(fraudCheckResponse.isFraudster())) {
            throw new IllegalStateException("fraudster");
        }
        // todo: send notification
    }
}
