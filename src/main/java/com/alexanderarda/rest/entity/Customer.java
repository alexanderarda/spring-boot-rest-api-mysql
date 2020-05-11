package com.alexanderarda.rest.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // AutoIncrement
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

}
