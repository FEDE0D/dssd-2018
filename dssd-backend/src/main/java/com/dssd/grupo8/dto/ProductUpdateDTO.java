package com.dssd.grupo8.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class ProductUpdateDTO {

    private String name;

    private Long costprice;

    private Long saleprice;

    private ProductTypeUpdateDTO type;

}
