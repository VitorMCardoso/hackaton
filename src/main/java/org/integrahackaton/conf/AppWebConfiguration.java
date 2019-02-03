package org.integrahackaton.conf;

import org.integrahackaton.controller.HelloWordController;
import org.integrahackaton.controller.PersonController;
import org.integrahackaton.dao.PersonDAO;
import org.integrahackaton.dao.UserDAO;
import org.integrahackaton.model.PersonRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@ComponentScan(basePackageClasses = {HelloWordController.class, UserDAO .class, PersonDAO.class, PersonRepository.class})
public class AppWebConfiguration {

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/view/");
        resolver.setSuffix(".jsp");

        return resolver;
    }
}
