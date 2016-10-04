package com.xyzcorp;


import com.google.inject.Guice;
import com.google.inject.Injector;
import com.xyzcorp.dao.AlbumDAO;
import com.xyzcorp.models.Album;
import org.h2.jdbcx.JdbcConnectionPool;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        Injector injector = Guice.createInjector(new AlbumModule());
        AlbumDAO dao = injector.getInstance(AlbumDAO.class);
        //dao.insert(new Album("The Ideal Copy", "Wire", 1987));

        JdbcConnectionPool pool = injector.getInstance(JdbcConnectionPool.class);
        pool.dispose();
    }
}
