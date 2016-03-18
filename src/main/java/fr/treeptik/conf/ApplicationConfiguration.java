package fr.treeptik.conf;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

////annotation pour déclarer que cette classe contient la configuration de spring
//@Configuration
//// indiquer le package à scanner pour récupérer les beans spring dans le projet
//@ComponentScan(basePackages = "fr.treeptik")
//// indique le chemin du fichier de properties à charger dans le fichier de
//// properties
//@PropertySource(value = "classpath:config.properties", name = "config")
//// active la gestion automatique des transactions dans la couche service
//@EnableTransactionManagement
public class ApplicationConfiguration {

	/*
	 * objet permettant notamment de récupérer les properties déclarées dans le
	 * fichier config.properties qui a été chargé via l'annotation
	 * 
	 * @PropertySource
	 */
	@Autowired
	private Environment environment;

	/*
	 * permet d'injecter un bean de configuration (ici la datasource dans le
	 * context de spring) dans le corps de la méthode, on créer un nouvel objet
	 * de type datasource, on indique via des setters toutes les propriétés du
	 * bean et on retourne l'objet datasource
	 */
	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		// on peut récupérer toutes les propriétés injectées dans le context
		// spring (provenant du fichier config.properties) via une méthode
		// getProperty() de l'objet Environment (on peut utiliser cette façon de
		// récupérer les propriétés partout dans le projet
		dataSource.setUrl(environment.getProperty("jdbc.url"));
		dataSource.setUsername(environment.getProperty("jdbc.user"));
		dataSource.setPassword(environment.getProperty("jdbc.password"));
		return dataSource;
	}

	/*
	 * De la même manière, on injecte tous les autres beans de configurations
	 * (entityManagerFactory, transactionManager etc...). On retrouve exactement
	 * les mêmes éléments que dans le fichier de configuration
	 * applicationContext.xml
	 */
	@Bean
	public EntityManagerFactory entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
		lcemfb.setPersistenceUnitName("persistenceUnit");
		lcemfb.setDataSource(dataSource());
		lcemfb.setJpaDialect(new HibernateJpaDialect());
		lcemfb.setJpaVendorAdapter(jpaVendorAdapter());
		lcemfb.setPackagesToScan("fr.treeptik.model");
		lcemfb.afterPropertiesSet();
		return lcemfb.getObject();
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setShowSql(true);
		jpaVendorAdapter.setGenerateDdl(true);
		jpaVendorAdapter
				.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
		return jpaVendorAdapter;
	}

	@Bean
	public HibernateExceptionTranslator hibernateExceptionTranslator() {
		return new HibernateExceptionTranslator();
	}

	@Bean(name = "transactionManager")
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(entityManagerFactory());
		return jpaTransactionManager;
	}

}
