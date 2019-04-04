package com.ecomm.GadgetBackend;

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
	@ComponentScan(basePackages="com.ecomm")
	@EnableTransactionManagement
	public class DBConfig {
		
			
			@Bean(name="dataSource")
			public DataSource getDataSource()
			{
				DriverManagerDataSource dataSource=new DriverManagerDataSource();
				dataSource.setDriverClassName("org.h2.Driver");
				dataSource.setUrl("jdbc:h2:tcp://localhost/~/demo");
				dataSource.setUsername("sa");
				dataSource.setPassword("");
				return dataSource;
			}
			
			@Bean(name="sessionFactory")
			public SessionFactory getSessionFactory(DataSource dataSource)
			{
				LocalSessionFactoryBuilder lsfb=new LocalSessionFactoryBuilder(getDataSource());
				Properties prop=new Properties();
				prop.put("hibernate.dialect",org.hibernate.dialect.H2Dialect.class);
				prop.put("hibernate.hbm2ddl.auto", "update");//fix
				lsfb.addProperties(prop);
				lsfb.scanPackages("com.ecomm");//fix
				SessionFactory sessionFactory=lsfb.buildSessionFactory();
				
				return sessionFactory;
			}

			@Bean("txMmanager")
			public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
			{
				
			return new HibernateTransactionManager(sessionFactory);	
			
	}
	}


