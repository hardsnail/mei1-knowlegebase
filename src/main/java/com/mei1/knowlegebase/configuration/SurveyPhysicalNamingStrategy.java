package com.mei1.knowlegebase.configuration;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.mei1.knowlegebase.common.util.Strings;

@Configuration
public class SurveyPhysicalNamingStrategy implements PhysicalNamingStrategy {

    @Value("${app.table.prefix}")
    private String tablePrefix;

    public SurveyPhysicalNamingStrategy surveyPhysicalNamingStrategy() {
        return new SurveyPhysicalNamingStrategy();
    }

    @Override
    public Identifier toPhysicalCatalogName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return name;
    }

    @Override
    public Identifier toPhysicalSchemaName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return name;
    }

    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return Identifier.toIdentifier(tablePrefix + Strings.humpToSnake(name.getText()));
    }

    @Override
    public Identifier toPhysicalSequenceName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return name;
    }

    @Override
    public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return Identifier.toIdentifier(Strings.humpToSnake(name.getText()));
    }

}
