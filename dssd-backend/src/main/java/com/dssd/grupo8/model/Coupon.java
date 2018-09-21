package com.dssd.grupo8.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Coupon {

    @Id
    private Long id;

    @NotNull
    private Long number;

    @NotNull
    private boolean used;

}
