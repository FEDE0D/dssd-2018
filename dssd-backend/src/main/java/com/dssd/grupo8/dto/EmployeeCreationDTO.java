package com.dssd.grupo8.dto;

import com.dssd.grupo8.model.EmployeeType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class EmployeeCreationDTO {

    @NonNull
    private String firstname;

    @NonNull
    private String surname;

    @NonNull
    private String email;

    private String password;

    @NonNull
    private EmployeeTypeCreationDTO type;
}
