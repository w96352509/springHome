package com.spring.core.session06;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@ComponentScan(basePackages = { "com.spring.core.session06" })
@PropertySource(value = { "classpath:db.properties" }, ignoreResourceNotFound = true)
@EnableTransactionManagement
public class SpringJDBCConfig {

	@Autowired
	protected Environment env;

	@Bean
	public DataSource dataSource() {
		ComboPooledDataSource ds = new ComboPooledDataSource();
		try {
			ds.setDriverClass(env.getProperty("jdbc.driver"));
			ds.setJdbcUrl(env.getProperty("jdbc.url"));
			ds.setUser(env.getProperty("jdbc.username"));
			ds.setPassword(env.getProperty("jdbc.password"));
            ds.setMinPoolSize(10);
			ds.setMaxPoolSize(100);
			ds.setInitialPoolSize(10);
			ds.setMaxIdleTime(1800);
			ds.setMaxStatements(100);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}

	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
	
	@Bean
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate() {
		return new NamedParameterJdbcTemplate(dataSource());
	}
	
	@Bean
	public DataSourceTransactionManager dataSourceTransactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}
	
}
