package zerobase.store.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zerobase.domain.config.JwtAuthenticationProvider;
import zerobase.store.domain.store.AddStoreForm;
import zerobase.store.domain.store.AddStoreInfoForm;
import zerobase.store.domain.store.StoreDto;
import zerobase.store.domain.store.StoreInfoDto;
import zerobase.store.service.store.StoreInfoService;
import zerobase.store.service.store.StoreService;

@RestController
@RequestMapping("/owner/store")
@RequiredArgsConstructor
public class OwnerStoreController {

    private final StoreService storeService;
    private final StoreInfoService storeInfoService;
    private final JwtAuthenticationProvider provider;

    @PostMapping
    public ResponseEntity<StoreDto> addStore(@RequestHeader(name = "X-AUTH-TOKEN") String token,
                                         @RequestBody AddStoreForm form) {

        return ResponseEntity.ok(StoreDto.from(storeService.addStore(provider.getUserVo(token).getId(), form)));
    }

    @PostMapping("info")
    public ResponseEntity<StoreDto> addStoreInfo(@RequestHeader(name = "X-AUTH-TOKEN") String token,
                                                 @RequestBody AddStoreInfoForm form) {

        return ResponseEntity.ok(StoreDto.from(storeInfoService.addStoreInfo(provider.getUserVo(token).getId(), form)));
    }
}
