package com.onlinesShopingBackend.cfg;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
 
@Configuration
@ComponentScan("com.onlinesShopingBackend")
@EnableTransactionManagement
public class DBcfg { 
	
	private final String Driver="org.h2.Driver";
	private final String Db_URL="jdbc:h2:tcp://localhost/~/P994";
	private final String Dialect="org.hibernate.dialect.H2Dialect";
	private final String Username="sa";
	private final String Password="";

	@Bean(name = "datasource")
	public DataSource getdataSource()
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(Driver);
		dataSource.setUrl(Db_URL);
		dataSource.setUsername(Username);
		dataSource.setPassword(Password);
		
		System.out.println("datasource created");
		return dataSource;
	}

	@Bean(name = "sessionFactory")
	public SessionFactory getsessionFactory(DataSource dataSource)
	{
		LocalSessionFactoryBuilder lsfd = new LocalSessionFactoryBuilder(dataSource);
		lsfd.addProperties(gethibernateProp());
		lsfd.scanPackages("com.onlinesShopingBackend.model");
		
		System.out.println("sessionFactory created");
		return lsfd.buildSessionFactory();
	}

	private Properties gethibernateProp()
	{
		Properties prop = new Properties();
		prop.put("hibernate.dialect", Dialect);
		prop.put("hibernate.hbm2ddl.auto", "update");
		prop.put("hibernate.show_sql", "true");
		prop.put("hibernate.format_sql", "true");
	
		System.out.println("hibernatre properties created");
		return prop;
	}

	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("Hibernate Transaction Manager created");
		return new HibernateTransactionManager(sessionFactory);
	}

}
