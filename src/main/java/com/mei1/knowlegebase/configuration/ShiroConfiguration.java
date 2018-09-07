package com.mei1.knowlegebase.configuration;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;

import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.AnonymousFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfiguration {

    @Bean
    public ShiroFilterFactoryBean shiroFilter() {
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager());
        shiroFilter.setLoginUrl("api/users/login");
        Map<String, String> filterChainDefinitionMap = new HashMap<>();
        filterChainDefinitionMap.put("/**", "authc");
        filterChainDefinitionMap.put("api/users/login", "anon");
        shiroFilter.setFilterChainDefinitionMap(filterChainDefinitionMap);
        Map<String, Filter> filters = new HashMap<>();
        filters.put("anon", anonymousFilter());
        shiroFilter.setFilters(filters);
        return shiroFilter;
    }

    @Bean
    public AnonymousFilter anonymousFilter() {
        return new AnonymousFilter();
    }

    @Bean
    public DefaultSecurityManager securityManager() {
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        return securityManager;
    }

}
