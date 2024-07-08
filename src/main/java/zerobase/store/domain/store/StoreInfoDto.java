package zerobase.store.domain.store;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import zerobase.store.domain.model.StoreInfo;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StoreInfoDto {
    private Long id;
    private String name;
    private String description;
    private String location;

    public static StoreInfoDto from(StoreInfo info) {
        return StoreInfoDto.builder()
                .id(info.getId())
                .name(info.getName())
                .description(info.getDescription())
                .location(info.getLocation())
                .build();
    }
}
