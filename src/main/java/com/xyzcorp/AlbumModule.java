package com.xyzcorp;

import com.google.inject.AbstractModule;
import org.h2.jdbcx.JdbcConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;

public class AlbumModule extends AbstractModule {
    @Override
    protected void configure() {
        final String url = "jdbc:h2:tcp://localhost/~/test";
        final String userName = "sa";
        final String password = "";
        final JdbcConnectionPool pool = JdbcConnectionPool.create(url, userName, password);
        bind(JdbcConnectionPool.class).toInstance(pool);
        bind(Connection.class).toProvider(() -> {
            try {
                return pool.getConnection();
            } catch (SQLException e) {
                throw new RuntimeException("Unable to retrieve Connection", e);
            }
        });
    }
}
