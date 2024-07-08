package zerobase.store.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zerobase.store.domain.model.Store;
import zerobase.store.domain.model.StoreInfo;

import java.util.Optional;

public interface StoreInfoRepository extends JpaRepository<StoreInfo, Long> {

}
