package conf;

import datamodel.Contact;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import services.data.ContactDAO;
import services.data.ContactJDBCDAO;

import javax.sql.DataSource;



@Configuration
public class AppConfiguration {


    @Bean
    public String myFirstBean() {
        return "Hello from Spring, 27173";
    }

    @Bean
    public Contact checkContact() {
        return new Contact("Mitsue", "Tollner", "773-573-6914", "773-924-8565", "mitsue_tollner@yahoo.com", "IL");
    }

    @Bean("conf.mainConf")
    public services.database.Configuration getConf() {
        return services.database.Configuration.getInstance();
    }

    @Bean("db.dataSource")
    public DataSource dataSource(@Qualifier("conf.mainConf") services.database.Configuration conf) {
        return new DriverManagerDataSource(conf.getDBUrl(), conf.getDBUser(), conf.getDBPassword());
    }

    @Bean("singleton.contactJDBCDAO")
    public ContactJDBCDAO contactJDBCDAO() {
        return new ContactJDBCDAO();
    }

}
