package com.dssd.grupo8.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class CouponDTO {

    @NonNull
    private Long id;

    @NonNull
    private Long number;

    @NonNull
    private boolean used;

}
