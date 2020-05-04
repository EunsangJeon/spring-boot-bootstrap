package com.eunsang.spring.basic.firstspring.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonDAO {

    public JdbcConnection getJdbcConnection() {
        return jdbcConnection;
    }

    public void setJdbcConnection(JdbcConnection jdbcConnection) {
        this.jdbcConnection = jdbcConnection;
    }

    @Autowired
    JdbcConnection jdbcConnection;
}
