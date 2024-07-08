package zerobase.store.service.store;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import zerobase.store.domain.model.Store;
import zerobase.store.domain.repository.StoreRepository;
import zerobase.store.domain.store.AddStoreForm;

@Service
@RequiredArgsConstructor
public class StoreService {
    private final StoreRepository storeRepository;

    @Transactional
    public Store addStore(Long ownerId, AddStoreForm form) {
        return storeRepository.save(Store.of(ownerId, form));
    }
}
