package com.example.springdatajpa.repositories;

import com.example.springdatajpa.t.Cat;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CatSpecifications extends JpaSpecificationExecutor<Cat>, PagingAndSortingRepository<Cat, Long> {
}
