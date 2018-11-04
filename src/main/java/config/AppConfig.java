package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"services", "dataaccess.DAO"})
public class AppConfig {

    @Bean
    public JdbcTemplate jdbcTemplate() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        Properties props = new Properties();
        try (FileInputStream in = new FileInputStream("src/main/resources/db.local.properties")) {
            props.load(in);
            dataSource.setUrl(props.getProperty("jdbc.url"));
            dataSource.setDriverClassName(props.getProperty("jdbc.driverClassName"));
            dataSource.setPassword(props.getProperty("jdbc.password"));
            dataSource.setUsername(props.getProperty("jdbc.username"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
