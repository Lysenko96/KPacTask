package org.example.kpactask.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;

@Configuration
@ComponentScan("org.example.kpactask")
@PropertySource("classpath:config.properties")
@EnableWebMvc
public class Config implements WebMvcConfigurer
{

    @Value("${db.driver}")
    private String driver;
    @Value("${db.url}")
    private String url;
    @Value("${db.user}")
    private String user;
    @Value("${db.password}")
    private String password;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource(url, user, password);
        dataSource.setDriverClassName(driver);
        return dataSource;
    }

    @Bean
    public ResourceDatabasePopulator databasePopulator() {
        return new ResourceDatabasePopulator(new ClassPathResource("schema.sql"), new ClassPathResource("data.sql"));
    }

    @Bean
    @Scope(value = "prototype")
    public JdbcTemplate jdbcTemplate(ResourceDatabasePopulator databasePopulator, DataSource dataSource) {
        DatabasePopulatorUtils.execute(databasePopulator, dataSource);
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        // for to work jsp and html together
//        resolver.setPrefix("/static/");
//        resolver.setPrefix("/WEB-INF/static/");
        resolver.setPrefix("");
//        resolver.setSuffix(".html");
        resolver.setSuffix("");
        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("/WEB-INF/static/");
    }

}