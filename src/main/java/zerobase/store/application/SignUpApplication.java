package zerobase.store.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import zerobase.store.domain.SignUpForm;
import zerobase.store.domain.model.Customer;
import zerobase.store.domain.model.Owner;
import zerobase.store.exception.CustomException;
import zerobase.store.exception.ErrorCode;
import zerobase.store.service.customer.SignUpCustomerService;
import zerobase.store.service.owner.OwnerService;

@Service
@RequiredArgsConstructor
public class SignUpApplication {
    private final SignUpCustomerService signUpCustomerService;
    private final OwnerService ownerService;

    public String customerSignUp(SignUpForm form) {
        if (signUpCustomerService.isEmailExist(form.getEmail())) {
            // exception
            throw new CustomException(ErrorCode.ALREADY_REGISTER_USER);
        } else {
            Customer c = signUpCustomerService.signUp(form);
            return "회원 가입에 성공하였습니다.";
        }
    }

    public String OwnerSignUp(SignUpForm form) {
        if (ownerService.isEmailExist(form.getEmail())) {
            // exception
            throw new CustomException(ErrorCode.ALREADY_REGISTER_USER);
        } else {
            Owner o = ownerService.signUp(form);
            return "회원 가입에 성공하였습니다.";
        }
    }
}
