package com.example.springdatajpaboot.mapper;

import com.example.springdatajpaboot.entity.Cat;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatMapper extends JpaSpecificationExecutor<Cat>, CrudRepository<Cat, Long> {
}
