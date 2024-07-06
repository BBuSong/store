package zerobase.store.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import zerobase.domain.common.UserType;
import zerobase.domain.config.JwtAuthenticationProvider;
import zerobase.store.domain.SignInForm;
import zerobase.store.domain.model.Customer;
import zerobase.store.exception.CustomException;
import zerobase.store.service.CustomerService;

import static zerobase.store.exception.ErrorCode.LOGIN_CHECK_FAIL;

@Service
@RequiredArgsConstructor
public class SignInApplication {

    private final CustomerService customerService;
    private final JwtAuthenticationProvider provider;
    public String customerLoginToken(SignInForm form) {
        // 1. 로그인 가능 여부
        Customer c = customerService.findValidCustomer(form.getEmail(), form.getPassword())
                .orElseThrow(() -> new CustomException(LOGIN_CHECK_FAIL));
        // 2. 토큰을 발행시키고
        // 3. 토큰을 response한다.
        return provider.createToken(c.getEmail(), c.getId(), UserType.CUSTOMER);
    }
}
