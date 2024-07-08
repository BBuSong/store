package zerobase.store.domain.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.Audited;
import zerobase.store.domain.store.AddStoreForm;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Audited
@AuditOverride(forClass = BaseEntity.class)
public class Store extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long ownerId;

    private String name;

    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id")
    private List<StoreInfo> storeInfos = new ArrayList<>();

    public static Store of(Long ownerId, AddStoreForm form) {
        return Store.builder()
                .ownerId(ownerId)
                .name(form.getName())
                .description(form.getDescription())
                .storeInfos(form.getAddStoreInfoForms().stream()
                        .map(piFrom -> StoreInfo.of(ownerId, piFrom)).collect(Collectors.toList()))
                .build();
    }

}
