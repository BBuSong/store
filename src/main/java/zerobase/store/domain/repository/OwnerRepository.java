package zerobase.store.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zerobase.store.domain.model.Owner;

import java.util.Optional;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
    Optional<Owner> findByIdAndEmail(Long id, String Email);
    Optional<Owner> findByEmailAndPasswordAndVerifyIsTrue(String email, String password);
    Optional<Owner> findByEmail(String email);
}
