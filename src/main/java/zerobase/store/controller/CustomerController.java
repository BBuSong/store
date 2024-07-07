package zerobase.store.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zerobase.domain.common.UserVo;
import zerobase.domain.config.JwtAuthenticationProvider;
import zerobase.store.domain.customer.CustomerDto;
import zerobase.store.domain.model.Customer;
import zerobase.store.exception.CustomException;
import zerobase.store.service.customer.CustomerService;

import static zerobase.store.exception.ErrorCode.NOT_FOUND_USER;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final JwtAuthenticationProvider provider;
    private final CustomerService customerService;

    @GetMapping("/getInfo")
    public ResponseEntity<CustomerDto> getInfo(@RequestHeader(name = "X-AUTH-TOKEN") String token) {
        UserVo vo = provider.getUserVo(token);
        Customer c = customerService.findByIdAndEmail(vo.getId(), vo.getEmail()).orElseThrow(
                () -> new CustomException(NOT_FOUND_USER)
        );

        return ResponseEntity.ok(CustomerDto.from(c));
    }

}
