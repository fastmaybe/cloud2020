package com.fastmay.springcloud.config;

import cn.hutool.db.Db;
import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.boot.context.properties.source.ConfigurationPropertySources;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Author: liulang
 * @Date: 2021/1/12 11:30
 */
@Configuration
public class DbConfig3 {



    class DbConf{
        private String driverClassName;
        private String url;
        private String password;
        private String username;

        public String getDriverClassName() {
            return driverClassName;
        }

        public void setDriverClassName(String driverClassName) {
            this.driverClassName = driverClassName;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }

    @Bean
    @ConfigurationProperties("spring.datasource")
    public DbConf dbConf(){
        return new DbConf();
    }

    @Bean(value = "dataSource",initMethod = "init",destroyMethod = "close")
    @RefreshScope
    public DruidDataSource dataSource(@Qualifier(value = "dbConf") DbConf dbConf) throws SQLException {

        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(dbConf.getDriverClassName());
        druidDataSource.setUrl(dbConf.getUrl());
        druidDataSource.setUsername(dbConf.getUsername());
        druidDataSource.setPassword(dbConf.getPassword());


//        druidDataSource.setDriverClassName(propertyResolver.getProperty("driverClassName"));
//        druidDataSource.setUrl(propertyResolver.getProperty("url"));
//        druidDataSource.setUsername(propertyResolver.getProperty("username"));
//        druidDataSource.setPassword(propertyResolver.getProperty("password"));
//        druidDataSource.setInitialSize(Integer.parseInt(propertyResolver.getProperty("initialSize")));
//        druidDataSource.setMinIdle(Integer.parseInt(propertyResolver.getProperty("minIdle")));
//        druidDataSource.setMaxActive(Integer.parseInt(propertyResolver.getProperty("maxActive")));
//        druidDataSource.setMaxWait(Integer.parseInt(propertyResolver.getProperty("maxWait")));
//        druidDataSource.setTimeBetweenEvictionRunsMillis(Long.parseLong(propertyResolver.getProperty("timeBetweenEvictionRunsMillis")));
//        druidDataSource.setMinEvictableIdleTimeMillis(Long.parseLong(propertyResolver.getProperty("minEvictableIdleTimeMillis")));
//        druidDataSource.setValidationQuery(propertyResolver.getProperty("validationQuery"));
//        druidDataSource.setTestWhileIdle(Boolean.parseBoolean(propertyResolver.getProperty("testWhileIdle")));
//        druidDataSource.setTestOnBorrow(Boolean.parseBoolean(propertyResolver.getProperty("testOnBorrow")));
//        druidDataSource.setTestOnReturn(Boolean.parseBoolean(propertyResolver.getProperty("testOnReturn")));
//        druidDataSource.setPoolPreparedStatements(Boolean.parseBoolean(propertyResolver.getProperty("poolPreparedStatements")));
//        druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(Integer.parseInt(propertyResolver.getProperty("maxPoolPreparedStatementPerConnectionSize")));
//        druidDataSource.setFilters(propertyResolver.getProperty("filters"));

        return druidDataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(@Qualifier(value = "dataSource") DruidDataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        Resource[] resources = new PathMatchingResourcePatternResolver().getResources("classpath*:/mapper/*.xml");
        sqlSessionFactoryBean.setMapperLocations(resources);
        return sqlSessionFactoryBean.getObject();
    }
}
