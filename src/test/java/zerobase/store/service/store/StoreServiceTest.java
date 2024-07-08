package zerobase.store.service.store;

import net.bytebuddy.dynamic.scaffold.MethodRegistry;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import zerobase.store.domain.model.Store;
import zerobase.store.domain.repository.StoreRepository;
import zerobase.store.domain.store.AddStoreForm;
import zerobase.store.domain.store.AddStoreInfoForm;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StoreServiceTest {

    @Autowired
    private StoreService storeService;
    @Autowired
    private StoreRepository storeRepository;

    @Test
    void addStore() {
        Long ownerId = 1L;

        AddStoreForm form = makeStoreForm("치킨집1", "강남 맛집");

        Store s = storeService.addStore(ownerId, form);

        Store result = storeRepository.findById(s.getId()).get();

        assertNotNull(result);

        // 필드들에 대한 검증
        assertEquals(result.getName(), "치킨집1");
        assertEquals(result.getDescription(), "강남 맛집");

    }

    private static AddStoreForm makeStoreForm(String name, String description) {
        List<AddStoreInfoForm> infoForms = new ArrayList<>();
        return AddStoreForm.builder()
                .name(name)
                .description(description)
                .build();
    }

    private static AddStoreInfoForm makeStoreInfoForm(Long storeId, String name) {
        return AddStoreInfoForm.builder()
                .storeId(storeId)
                .name(name)
                .description("치킨 맛집")
                .location("서울시 1번지")
                .build();
    }
}