package com.mei1.knowlegebase.ext.jersey;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ws.rs.Path;

import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJsonProvider;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @PostConstruct
    public void init() {

        register(JacksonJsonProvider.class);
        register(ResultProvider.class);
        register(ThrowableMapper.class);

        Map<String, Object> beanMap = applicationContext.getBeansWithAnnotation(Path.class);
        registerInstances(beanMap.values().toArray());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

}
