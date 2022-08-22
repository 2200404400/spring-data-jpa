package com.example.springdatajpaboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cat")
public class Cat {
    @Id
    @GeneratedValue
    @Column(name = "uid")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "my_cat")
    @LastModifiedBy
    private Integer myCat;

    @Column(name = "is_delete")
    @CreatedBy
    private Integer isDelete;

    @Column(name = "create_time")
    @CreatedDate
    private Date createTime;

    @Column(name = "update_time")
    @LastModifiedDate
    private Date updateTime;

    @Column(name = "version")
    @Version
    private Integer version;

    @OneToOne
    @JoinColumn(name = "two_id")
    private Two two;
}
