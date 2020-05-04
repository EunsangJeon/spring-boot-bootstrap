package com.eunsang.spring.basic.firstspring.scope;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
// above to make sure the class has been scoped again and get another instance
public class JdbcConnection {

    public JdbcConnection() {
        System.out.println("JDBC Connection");
    }
}
