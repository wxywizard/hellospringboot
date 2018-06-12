package com.wxywizard.jpaConfig;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Primary
    @Bean(name = "primaryDataSourceProperties")
    @Qualifier("primaryDataSourceProperties")
    @ConfigurationProperties(prefix="spring.datasource.druid.one")
    public DataSourceProperties primaryDataSourceProperties(){
        return new DataSourceProperties();
    }

    @Bean(name = "primaryDataSource")
    @Qualifier("primaryDataSource")
    @Primary
    @ConfigurationProperties(prefix="spring.datasource.druid.one")
    public DataSource primaryDataSource() {
       // return DataSourceBuilder.create().build();
        return primaryDataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean(name = "secondaryDataSourceProperties")
    @Qualifier("secondaryDataSourceProperties")
    @ConfigurationProperties(prefix="spring.datasource.druid.two")
    public DataSourceProperties secondaryDataSourceProperties(){
        return new DataSourceProperties();
    }

    @Bean(name = "secondaryDataSource")
    @Qualifier("secondaryDataSource")
    @ConfigurationProperties(prefix="spring.datasource.druid.two")
    public DataSource secondaryDataSource() {
       // return DataSourceBuilder.create().build();
        return secondaryDataSourceProperties().initializeDataSourceBuilder().build();
    }

}

