package org.crm.core;

import org.crm.common.domain.User;
import org.crm.common.domain.UserRole;
import org.crm.core.repositories.UserRepository;
import org.crm.core.repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableJpaRepositories
@Import(RepositoryRestMvcConfiguration.class)
@EntityScan(basePackages = "org.crm.common.domain")
public class CoreApplication {
    public static void main(String args[]){
        //SpringApplication.run(CoreApplication.class, args);
        ConfigurableApplicationContext context = SpringApplication.run(CoreApplication.class);

        // Initial data
        UserRepository userRepository = context.getBean(UserRepository.class);
        UserRoleRepository userRoleRepository = context.getBean(UserRoleRepository.class);

        UserRole adminRole;
        UserRole userRole;
        User user;
        User admin;

        adminRole = new UserRole();
        adminRole.setRoleName("admin");
        userRoleRepository.save(adminRole);

        userRole = new UserRole();
        userRole.setRoleName("user");
        userRoleRepository.save(userRole);

        user = new User();
        user.setUserName("alexhustas");
        user.setFirstName("Firstname");
        user.setLastName("Lastname");
        user.addRole(userRole);
        user.addRole(adminRole);
        userRepository.save(user);

        admin = new User();
        admin.setUserName("admin");
        admin.setFirstName("Firstname");
        admin.setLastName("Lastname");
        admin.addRole(adminRole);
        admin.addRole(userRole);
        userRepository.save(admin);


        user = new User();
        user.setUserName("bob");
        user.setFirstName("Bob");
        user.setLastName("Bee");
        user.addRole(userRole);
        userRepository.save(user);

        user = new User();
        user.setUserName("jack");
        user.setFirstName("Jack");
        user.setLastName("Jee");
        user.addRole(userRole);
        userRepository.save(user);

        // Security

    }

    @Order(Ordered.HIGHEST_PRECEDENCE + 10)
    protected static class AuthenticationSecurity extends
            GlobalAuthenticationConfigurerAdapter {

        @Autowired
        private DataSource dataSource;

        @Override
        public void init(AuthenticationManagerBuilder auth) throws Exception {

            auth.inMemoryAuthentication()
                    .withUser("admin").password("admin").roles("ADMIN", "USER").and()
                    .withUser("user").password("user").roles("USER");
            /*
            auth.jdbcAuthentication().dataSource(this.dataSource).withUser("admin")
                    .password("admin").roles("ADMIN", "USER").and().withUser("user")
                    .password("user").roles("USER");
            */
        }
    }
}