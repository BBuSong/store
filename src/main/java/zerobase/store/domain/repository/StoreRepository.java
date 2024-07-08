package zerobase.store.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zerobase.store.domain.model.Store;

import java.util.Optional;


public interface StoreRepository extends JpaRepository<Store, Long> {
    Optional<Store> findByOwnerIdAndId(Long ownerId, Long id);

}
