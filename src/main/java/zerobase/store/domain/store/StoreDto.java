package zerobase.store.domain.store;

import lombok.*;
import zerobase.store.domain.model.Store;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StoreDto {
    private Long id;
    private String name;
    private String description;
    private List<StoreInfoDto> infos;

    public static StoreDto from(Store store) {
        List<StoreInfoDto> infos = store.getStoreInfos()
                .stream().map(StoreInfoDto::from).collect(Collectors.toList());

        return StoreDto.builder()
                .id(store.getId())
                .name(store.getName())
                .description(store.getDescription())
                .infos(infos)
                .build();
    }
}
