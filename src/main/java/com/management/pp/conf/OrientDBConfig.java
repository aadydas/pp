package com.management.pp.conf;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class OrientDBConfig {
    @Value("remote:localhost/testDB")
    private String url;

    @Value("root")
    private String username;

    @Value("root")
    private String password;

    private boolean transactional;
}
