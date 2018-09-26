package com.dssd.grupo8.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NonNull
    private String name;

    @NotNull
    @NonNull
    private Long costprice;

    @NotNull
    @NonNull
    private Long saleprice;

    @NotNull
    @NonNull
    @ManyToOne
    @JoinColumn(name = "producttype")
    private ProductType type;

}
