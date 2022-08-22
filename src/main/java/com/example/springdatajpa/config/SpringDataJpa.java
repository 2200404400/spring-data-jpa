package com.example.springdatajpa.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

// 设为配置类
@Configuration
// 启动Jpa，扫描mapper层
@EnableJpaRepositories(basePackages = "com.example.springdatajpa.repositories")
// 启动事务
@EnableTransactionManagement
public class SpringDataJpa {

    // 数据源
    @Bean
    public DataSource dataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://192.168.70.101:3306/test?serverTimezone=GMT%2B8");
        druidDataSource.setUsername("admin");
        druidDataSource.setPassword("admin");
        return druidDataSource;
    }

    // 基础信息，方法名必须为entityManagerFactory，若不一致则在@Bean里添加name=entityManagerFactory
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        // 生成DDL？
        hibernateJpaVendorAdapter.setGenerateDdl(true);

        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(hibernateJpaVendorAdapter);
        // 扫描实体类的包
        localContainerEntityManagerFactoryBean.setPackagesToScan("com.example.springdatajpa.t");
        // 设置数据源
        localContainerEntityManagerFactoryBean.setDataSource(dataSource());
        return localContainerEntityManagerFactoryBean;
    }

    // 事务，方法名必须为transactionManager，若不一致则在@Bean里添加name=transactionManager
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory){
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);
        return jpaTransactionManager;
    }
}
