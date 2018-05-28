package com.wxywizard.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "spring.datasource.master" )
@PropertySource("classpath:application-datasource.yml")
public class DruidSettings {

    private String type;
    private String driverClassName;
    private String url;
    private String username;
    private String password;

    private Integer initialSize;
    private Integer minIdle;
    private Integer maxActive;
    private Long maxWait;
    private Long timeBetweenEvictionRunsMillis;
    private Long minEvictableIdleTimeMillis;
    private String validationQuery;
    private boolean testWhileIdle;
    private boolean testOnBorrow;
    private boolean testOnReturn;
    private boolean poolPreparedStatements;
    private Integer maxPoolPreparedStatementPerConnectionSize;
    private String filters;
    private String connectionProperties;
    private boolean useGlobalDataSourceStat;

    //省略getter/setter方法

}
