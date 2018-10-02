package com.dssd.grupo8.dto;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class ProductTypeCreationDTO {

    @NonNull
    private String initials;

    @NonNull
    private String description;
}
