package zerobase.store.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zerobase.store.application.SignInApplication;
import zerobase.store.application.SignUpApplication;
import zerobase.store.domain.SignInForm;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/signIn")
public class SignInController {

    private final SignInApplication signInApplication;

    @PostMapping("customer")
    public ResponseEntity<String> signInCustomer(@RequestBody SignInForm form) {
        return ResponseEntity.ok(signInApplication.customerLoginToken(form));
    }
}
