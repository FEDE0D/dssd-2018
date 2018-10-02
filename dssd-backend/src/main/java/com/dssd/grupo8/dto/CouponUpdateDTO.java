package com.dssd.grupo8.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class CouponUpdateDTO {

    @NonNull
    private Long number;

    @NonNull
    private boolean used;

}
