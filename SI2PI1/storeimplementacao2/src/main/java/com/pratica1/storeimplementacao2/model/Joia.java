package com.pratica1.storeimplementacao2.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Joia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 100, nullable = false)
    private String material;

    @Column(nullable = false)
    private Double peso;

    @Column(nullable = false)
    private Double quilates;

}
