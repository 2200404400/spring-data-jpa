package com.example.springdatajpa.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

/**
 * 当发生创建与更新时会获取这里的数据填充到@CreateBy和@LastModifiedBy的字段里
 */
@Configuration
public class MyAuditorAware implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("admin");
    }
}
