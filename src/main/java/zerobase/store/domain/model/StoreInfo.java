package zerobase.store.domain.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.Audited;
import zerobase.store.domain.store.AddStoreInfoForm;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Audited
@AuditOverride(forClass = BaseEntity.class)
public class StoreInfo extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long ownerId;

    @Audited
    private String name;

    @Audited
    private String description;

    @Audited
    private String location;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id")
    private Store store;

    public static StoreInfo of(Long ownerId, AddStoreInfoForm form) {
        return StoreInfo.builder()
                .ownerId(ownerId)
                .name(form.getName())
                .description(form.getDescription())
                .location(form.getLocation())
                .build();

    }
}
