package zerobase.store.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zerobase.store.domain.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
