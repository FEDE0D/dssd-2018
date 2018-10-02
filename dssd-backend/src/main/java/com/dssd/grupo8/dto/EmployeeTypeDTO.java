package com.dssd.grupo8.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class EmployeeTypeDTO {

    @NonNull
    private Long id;

    @NonNull
    private String initials;

    @NonNull
    private String description;
}
