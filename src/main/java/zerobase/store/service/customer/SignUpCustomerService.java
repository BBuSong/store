package zerobase.store.service.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import zerobase.store.domain.SignUpForm;
import zerobase.store.domain.model.Customer;
import zerobase.store.domain.repository.CustomerRepository;

import java.util.Locale;

@Service
@RequiredArgsConstructor
public class SignUpCustomerService {

    private final CustomerRepository customerRepository;

    public Customer signUp(SignUpForm form) {
        return customerRepository.save(Customer.from(form));
    }

    public boolean isEmailExist(String email) {
        return customerRepository.findByEmail(email.toLowerCase(Locale.ROOT))
                .isPresent();
    }

}
