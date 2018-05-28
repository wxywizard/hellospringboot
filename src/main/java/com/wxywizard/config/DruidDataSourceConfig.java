package com.wxywizard.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


import javax.sql.DataSource;
import java.sql.SQLException;


@Slf4j
@Configuration
@Primary
@EnableConfigurationProperties(DruidSettings.class)
public class DruidDataSourceConfig extends DataSourceProperties {

    @Autowired
    private DruidSettings druidSettings;

    @Bean     //声明其为Bean实例
    public DataSource dataSource(){
        DruidDataSource datasource = new DruidDataSource();

        datasource.setUrl(druidSettings.getUrl());
        datasource.setUsername(druidSettings.getUsername());
        datasource.setPassword(druidSettings.getPassword());
        datasource.setDriverClassName(druidSettings.getDriverClassName());

        //configuration
        datasource.setInitialSize(druidSettings.getInitialSize());
        datasource.setMinIdle(druidSettings.getMinIdle());
        datasource.setMaxActive(druidSettings.getMaxActive());
        datasource.setMaxWait(druidSettings.getMaxWait());
        datasource.setTimeBetweenEvictionRunsMillis(druidSettings.getTimeBetweenEvictionRunsMillis());
        datasource.setMinEvictableIdleTimeMillis(druidSettings.getMinEvictableIdleTimeMillis());
        datasource.setValidationQuery(druidSettings.getValidationQuery());
        datasource.setTestWhileIdle(druidSettings.isTestWhileIdle());
        datasource.setTestOnBorrow(druidSettings.isTestOnBorrow());
        datasource.setTestOnReturn(druidSettings.isTestOnReturn());
        datasource.setPoolPreparedStatements(druidSettings.isPoolPreparedStatements());
        datasource.setMaxPoolPreparedStatementPerConnectionSize(druidSettings.getMaxPoolPreparedStatementPerConnectionSize());
        try {
            datasource.setFilters(druidSettings.getFilters());
        } catch (SQLException e) {
            log.error("druid configuration initialization filter", e);
        }
        datasource.setConnectionProperties(druidSettings.getConnectionProperties());

        return datasource;
    }
}
