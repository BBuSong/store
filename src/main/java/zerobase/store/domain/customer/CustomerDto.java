package zerobase.store.domain.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import zerobase.store.domain.model.Customer;

@Getter
@Setter
@AllArgsConstructor
public class CustomerDto {

    private Long id;
    private String email;

    public static CustomerDto from(Customer customer) {
        return new CustomerDto(customer.getId(), customer.getEmail());
    }

}
