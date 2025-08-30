package com.sample.util;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "com.sample")
@PropertySource("classpath:db.properties")
public class CalculatorAppConfig {
	
	  @Autowired
	    private Environment env;

	    @Bean
	    public DataSource dataSource() {
	        DriverManagerDataSource ds = new DriverManagerDataSource();
	        ds.setDriverClassName(env.getProperty("jdbc.driver"));
	        ds.setUrl(env.getProperty("jdbc.url"));
	        ds.setUsername(env.getProperty("jdbc.username"));
	        ds.setPassword(env.getProperty("jdbc.password"));
	        return ds;
	    }

	    @Bean
	    public JdbcTemplate jdbcTemplate(DataSource ds) {
	        return new JdbcTemplate(ds);
	    }
	// setup ViewResolver
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}