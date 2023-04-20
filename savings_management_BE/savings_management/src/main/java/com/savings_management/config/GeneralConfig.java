package com.savings_management.config;

import com.savings_management.entity.VariabiliMese;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class GeneralConfig implements RepositoryRestConfigurer {
    @Value("${allowed.origins}")
    private String[] theAllowedOrigins;

    // read only
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);
        HttpMethod[] theUnsupportedActions = new HttpMethod[]{HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE, HttpMethod.PATCH};
        this.disableHttpMethods(VariabiliMese.class, config, theUnsupportedActions);

    }

    private void disableHttpMethods(Class theClass, RepositoryRestConfiguration config, HttpMethod[] theUnsupportedActions) {
        config.getExposureConfiguration().forDomainType(theClass).withItemExposure((metdata, httpMethods) -> {
           return httpMethods.disable(theUnsupportedActions);
        }).withCollectionExposure((metdata, httpMethods) -> {
            return httpMethods.disable(theUnsupportedActions);
        });
    }
}
