package com.dssd.grupo8.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class ProductDTO {

    @NonNull
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private Long costprice;

    @NonNull
    private Long saleprice;

    @NonNull
    private ProductTypeDTO type;

}
