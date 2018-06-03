package com.inc.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
public class DatabaseConfig {
	@Bean
	public SqlSession sqlSession(SqlSessionFactory sqlSessionFactory) {
		return  new SqlSessionTemplate(sqlSessionFactory);
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setConfigLocation(
			new PathMatchingResourcePatternResolver().getResource(
				"classpath:mybatis/config/mybatis-context.xml"));
		sqlSessionFactory.setDataSource(dataSource);
		return sqlSessionFactory.getObject();
	}
}
