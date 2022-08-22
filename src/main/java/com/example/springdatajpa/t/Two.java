package com.example.springdatajpa.t;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "two")
public class Two {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;
}
