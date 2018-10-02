package com.dssd.grupo8.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeUpdateDTO {

    private String firstname;

    private String surname;

    private String email;

    private String password;

    private EmployeeTypeUpdateDTO type;
}
