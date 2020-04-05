package com.management.pp.conf;

import org.apache.tinkerpop.gremlin.orientdb.OrientGraphFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DBConfig {

    @Bean
    public OrientGraphFactory createOrientGraphFactory() {
        return new OrientGraphFactory();
    }
}
