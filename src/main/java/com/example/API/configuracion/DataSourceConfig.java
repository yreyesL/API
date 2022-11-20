package com.example.API.configuracion;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Value("${usr}")
    private String usuario;
    @Value("${cls}")
    private String clave;

    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:sqlserver://localhost;databaseName=YDRL;trustServerCertificate=true");
        dataSourceBuilder.username(usuario);
        dataSourceBuilder.password(clave);
        return dataSourceBuilder.build();
    }
}
