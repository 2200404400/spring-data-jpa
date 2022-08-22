package com.example.demo;

import com.example.springdatajpa.config.SpringDataJpa;
import com.example.springdatajpa.repositories.CatQueryDslRepository;
import com.example.springdatajpa.repositories.CatRepository;
import com.example.springdatajpa.repositories.CatSpecifications;
import com.example.springdatajpa.t.Cat;
import com.example.springdatajpa.t.QCat;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.List;

@SpringBootTest
//@ContextConfiguration("/spring.xml")
@ContextConfiguration(classes = SpringDataJpa.class)
class DemoApplicationTests {

    @Resource
    private CatRepository catRepository;

    @Resource
    private CatQueryDslRepository catQueryDslRepository;

    @Resource
    private CatSpecifications catSpecifications;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    void contextLoads() {
        Cat cat = new Cat(4, "1", 2, "2", 3);
        catRepository.save(cat);

    }

    @Test
    void go() {
        Cat byId = catRepository.getById(0, 7);
        System.out.println(byId);
    }

    @Test
    void yes() {
        // 过滤器
        ExampleMatcher matching = ExampleMatcher.matching();
        // 忽略的属性
        matching.withIgnorePaths("uid", "id");
        // 忽略大小写
        matching.withIgnoreCase();

        // 查询条件
        Cat cat = new Cat();
        cat.setId(1);
        cat.setAge(2);
        cat.setVersion(0);
        cat.setName("1");
        cat.setIsDelete(3);
        cat.setMyCat("2");

        // 查询器
        Example<Cat> of = Example.of(cat, matching);

        // 获得数据并遍历00
        System.out.println("==========================================");
        Iterable<Cat> all = catRepository.findAll(of);
        for (Cat cat1 : all) {
            System.out.println(cat1 + "=====================");
        }
        System.out.println("==========================================");
    }

    @Test
    void no() {
        // 获取实例
        QCat cat = QCat.cat;

        // 判断语句，等同于Where
        BooleanExpression eq = cat.id.eq(1);

        // 查询并遍历数据
        Iterable<Cat> all = catQueryDslRepository.findAll(eq);
        for (Cat cat1 : all) {
            System.out.println(cat1);
        }
    }

    @Test
    void iPhone() {
        List<Cat> all = catSpecifications.findAll(new Specification<Cat>() {
            @Override
            public Predicate toPredicate(Root<Cat> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                /**
                 * ( > _ <)
                 * root 字段获取
                 * criteriaQuery 语句
                 * criteriaBuilder 判断关键字
                 */
                // 字段获取
                Path<Object> uid = root.get("id");

                // 判断，相当于Where，可以用一下两种方式
                Predicate notNull = uid.isNotNull();
                Predicate equal = criteriaBuilder.equal(uid, 1);

                Order desc = criteriaBuilder.desc(uid);
                CriteriaQuery<?> criteriaQuery1 = criteriaQuery.where(equal).orderBy(desc);
                return notNull;
            }
        });

        for (Cat cat : all) {
            System.out.println(cat + "21asd321sa21dsa3da1dsa");
        }
    }

    @Test
    void entityManager() {
        // 用于获取字段
        QCat cat = QCat.cat;

        // 查询器
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);

        // 查询
        JPAQuery<Integer> integerJPAQuery = jpaQueryFactory.select(cat.id)
                .from(cat)
                .where(cat.id.eq(1))
                .orderBy(cat.id.desc());

        // 获取数据并输出
        List<Integer> fetch = integerJPAQuery.fetch();
        for (Integer integer : fetch) {
            System.out.println(integer);
        }
    }
}
