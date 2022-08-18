package com.example.springdatajpa.t;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

// 证明这个类是实体类
@Entity
// 数据库表名
@Table(name = "cat")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cat {
    // 这个是主键
    @Id
    // 主键类型
    @GeneratedValue()
    // 数据库的字段名
    @Column(name = "uid")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "my_cat")
    private String myCat;

    @Column(name = "is_delete")
    private int isDelete;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "version")
    private int version;

    public Cat(int id, String name, int age, String myCat, int isDelete) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.myCat = myCat;
        this.isDelete = isDelete;
    }
}
