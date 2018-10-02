package com.dssd.grupo8.dto;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class EmployeeDTO {

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @NonNull
    private String firstname;

    @NonNull
    private String surname;

    @NonNull
    private String email;

    private String password;

    @NonNull
    private EmployeeTypeDTO type;
}
