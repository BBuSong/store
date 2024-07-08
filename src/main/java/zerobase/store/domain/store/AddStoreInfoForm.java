package zerobase.store.domain.store;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddStoreInfoForm {
    private Long storeId;
    private String name;
    private String description;
    private String location;
}
