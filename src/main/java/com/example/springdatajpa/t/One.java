package com.example.springdatajpa.t;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity
@Data
@Table(name = "one")
@EnableJpaAuditing
public class One {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = false, optional = true)
    @JoinColumn(name = "two_id")
    private Two two;

    @Column(name = "name")
    private String name;

    @Version
    private Long version;
}
