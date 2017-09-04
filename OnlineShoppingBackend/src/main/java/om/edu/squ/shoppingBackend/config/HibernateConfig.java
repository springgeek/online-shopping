package om.edu.squ.shoppingBackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages={"om.edu.squ.shoppingBackendDTO"})
@EnableTransactionManagement
public class HibernateConfig {


	private final static String database_url="jdbc:h2:tcp://localhost/~/onlineshoppingdb";
	private final static String database_driver="org.h2.Driver";
	private final static String database_dialect="org.hibernate.dialect.H2Dialect";
	private final static String database_user="sa";
	private final static String database_pwd="";
	
	@Bean
	public DataSource getDataSource(){
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(database_driver);
		dataSource.setUrl(database_url);
		dataSource.setUsername(database_user);
		dataSource.setPassword(database_pwd);
		return dataSource;
	}
	
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource){
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.scanPackages("om.edu.squ.shoppingBackend.DTO");
		return sessionBuilder.buildSessionFactory();
		
	}
	
	private Properties getHibernateProperties(){
		Properties properties = new Properties();
		properties.put("database_dialect", database_dialect);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		return properties;
	}
	
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){
		HibernateTransactionManager transManager = new HibernateTransactionManager(sessionFactory);
		return transManager;
	}
}
