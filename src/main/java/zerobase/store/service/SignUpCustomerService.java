package zerobase.store.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import zerobase.store.domain.SignUpForm;
import zerobase.store.domain.model.Customer;
import zerobase.store.domain.repository.CustomerRepository;

@Service
@RequiredArgsConstructor
public class SignUpCustomerService {

    private final CustomerRepository customerRepository;

    public Customer signUp(SignUpForm form) {
        return customerRepository.save(Customer.from(form));
    }
}
