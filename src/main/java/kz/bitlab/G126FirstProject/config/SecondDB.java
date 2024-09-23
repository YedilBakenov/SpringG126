package kz.bitlab.G126FirstProject.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryRef2",
        basePackages = "kz.bitlab.G126FirstProject.repository2",
        transactionManagerRef = "transactionManager2"
)
public class SecondDB {
    @Bean(name = "dataSource2")
    @ConfigurationProperties(prefix = "spring.db2.datasource")
    public DataSource dataSource2() {
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "entityManagerFactoryRef2")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory2(
            EntityManagerFactoryBuilder builder,
            @Qualifier("dataSource2") DataSource dataSource) {
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "update");

        return builder.dataSource(dataSource)
                .properties(properties)
                .packages("kz.bitlab.G126FirstProject.model2")
                .persistenceUnit("db2")
                .build();
    }

    @Bean(name = "transactionManager2")
    public PlatformTransactionManager transactionManager2(
            @Qualifier("entityManagerFactoryRef2") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
