package zerobase.store.domain.store;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddStoreForm {

    private String name;
    private String description;
    private List<AddStoreInfoForm> addStoreInfoForms;
}
