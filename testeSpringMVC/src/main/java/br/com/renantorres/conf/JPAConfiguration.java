package br.com.renantorres.conf;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//Responsável por configurar o framework, passando informações relevantes como o banco a ser utilizado, seu usuário e senha

//Para o Spring gerenciar as transações
@EnableTransactionManagement
public class JPAConfiguration {
	
	 @Bean
	    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

			LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
			
			JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
			factoryBean.setJpaVendorAdapter(vendorAdapter);
			
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setUsername("root");
			dataSource.setPassword("");
			dataSource.setUrl("jdbc:mariadb://localhost:3307/testeSpringMVC");
	        dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
			factoryBean.setDataSource(dataSource);
			
			Properties properties = new Properties();
			properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MariaDB53Dialect");
			properties.setProperty("hibernate.show_sql", "true");
			properties.setProperty("hibernate.hbm2ddl.auto", "update");
			
			factoryBean.setJpaProperties(properties);
			factoryBean.setPackagesToScan("br.com.renantorres.dominio");
			
			return factoryBean;
	 }
	 
	 //bean que será o gerenciador das transações, isto é, a partir desse bean, o Spring fornecerá as transações para o EntityManager
	 @Bean
	 public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
	     return new JpaTransactionManager(emf);
	 }
}
