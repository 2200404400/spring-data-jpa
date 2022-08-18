package com.example.springdatajpa.repositories;

import com.example.springdatajpa.t.Cat;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface CatRepository extends CrudRepository<Cat,Integer>, QueryByExampleExecutor<Cat> {
    @Query("from Cat where uid = ?1 and name = '2'")
    Cat getById(int i, int o);
}
