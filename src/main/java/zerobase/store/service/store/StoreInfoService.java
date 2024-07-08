package zerobase.store.service.store;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import zerobase.store.domain.model.Store;
import zerobase.store.domain.model.StoreInfo;
import zerobase.store.domain.repository.StoreInfoRepository;
import zerobase.store.domain.repository.StoreRepository;
import zerobase.store.domain.store.AddStoreInfoForm;
import zerobase.store.exception.CustomException;

import static zerobase.store.exception.ErrorCode.NOT_FOUND_STORE;
import static zerobase.store.exception.ErrorCode.SAME_STORE_NAME;

@Service
@RequiredArgsConstructor
public class StoreInfoService {

    private final StoreRepository storeRepository;
    private final StoreInfoRepository storeInfoRepository;

    public Store addStoreInfo(Long ownerId, AddStoreInfoForm form) {
        Store store = storeRepository.findByOwnerIdAndId(ownerId,form.getStoreId())
        .orElseThrow(() -> new CustomException(NOT_FOUND_STORE));
        if(store.getStoreInfos().stream()
                .anyMatch(info -> info.getName().equals(form.getName()))){
            throw new CustomException(SAME_STORE_NAME);
        }

        StoreInfo storeInfo = StoreInfo.of(ownerId, form);
        store.getStoreInfos().add(storeInfo);
        return store;

    }
}
