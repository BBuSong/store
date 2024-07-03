package zerobase.store.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import zerobase.store.domain.SignUpForm;
import zerobase.store.domain.model.Customer;
import zerobase.store.exception.CustomException;
import zerobase.store.exception.ErrorCode;
import zerobase.store.service.SignUpCustomerService;

@Service
@RequiredArgsConstructor
public class SignUpApplication {
    private final SignUpCustomerService signUpCustomerService;

    public String customerSignUp(SignUpForm form) {
        if (signUpCustomerService.isEmailExist(form.getEmail())) {
            // exception
            throw new CustomException(ErrorCode.ALREADY_REGISTER_USER);
        } else {
            Customer c = signUpCustomerService.signUp(form);
        }
    }
}
