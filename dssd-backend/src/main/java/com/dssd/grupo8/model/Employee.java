package com.dssd.grupo8.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NonNull
    private String firstname;

    @NotNull
    @NonNull
    private String surname;

    @NotNull
    @NonNull
    private String email;

    private String password;

    @NotNull
    @NonNull
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "employeetype")
    private EmployeeType type;

}
