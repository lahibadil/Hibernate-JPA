package com.lahib.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by Adil on 3/22/2017.
 */
@Configuration
@EnableJpaRepositories(basePackages = {"com.lahib.data.repositories"})
@EnableTransactionManagement
public class AppConfig {

    @Bean
    public DataSource dataSource(){
        final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
        dsLookup.setResourceRef(true);
        DataSource dataSource = dsLookup
                .getDataSource("jdbc:mysql://localhost:3306/finances");
        return dataSource;
    }

    @Bean
    public EntityManagerFactory entityManagerFactory(){
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setShowSql(true);
        vendorAdapter.setGenerateDdl(true);
        vendorAdapter.setDatabase(Database.MYSQL);

        Properties properties = new Properties();
        properties.put("hibernate.connection.driver_class","com.mysql.jdbc.Driver");
        properties.put("hibernate.connection.url","jdbc:mysql://localhost:3306/finances");
        properties.put("hibernate.connection.username","root");
        properties.put("hibernate.connection.password","password");
        properties.put("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");

        LocalContainerEntityManagerFactoryBean managerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        managerFactoryBean.setDataSource(dataSource());
        managerFactoryBean.setPackagesToScan("com.lahib.data.entities");
        managerFactoryBean.setJpaVendorAdapter(vendorAdapter);
        managerFactoryBean.setJpaProperties(properties);
        managerFactoryBean.afterPropertiesSet();

        return managerFactoryBean.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager(){
       JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory());
        return txManager;
    }


}
