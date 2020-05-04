package com.eunsang.spring.basic.componentscan;

import org.springframework.stereotype.Component;

@Component
public class ComponentJdbcConnection {

    public ComponentJdbcConnection() {
        System.out.println("JDBC Connection");
    }
}
