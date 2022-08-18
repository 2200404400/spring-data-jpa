package com.example.springdatajpa.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateSessionFactory {

    public static void main(String[] args) {
        // 构建配置文件
        StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();
        // 获取会话工厂
        SessionFactory sessionFactory = new MetadataSources(standardServiceRegistry).buildMetadata().buildSessionFactory();
        // 获取连接
        Session session = sessionFactory.openSession();
        // 访问持久层
        session.delete("id", 1);
    }
}
