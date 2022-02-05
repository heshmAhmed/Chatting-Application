package gov.iti.jets.server.repository.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * gitHub: HeshmAhmed on 2022/02/5
 */

public class DataSourceFactory {
    private final String PROPERTIES_PATH = "/db.properties";
    private final HikariDataSource hikariDataSource;
    private final HikariConfig hikariConfig;
    private final Properties connectionProperties;
    private static DataSourceFactory dataSourceFactory = new DataSourceFactory();

    private DataSourceFactory() {
        this.connectionProperties = readConnectionProperties();
        this.hikariConfig = prepareHikariConfig();
        this.hikariDataSource = new HikariDataSource(hikariConfig);
    }

    public static DataSourceFactory getInstance() {
        return dataSourceFactory;
    }

    public Connection getConnection() throws SQLException {
        return hikariDataSource.getConnection();
    }

    private HikariConfig prepareHikariConfig() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(connectionProperties.getProperty("url"));
        hikariConfig.setUsername(connectionProperties.getProperty("username"));
        hikariConfig.setPassword(connectionProperties.getProperty("password"));
        hikariConfig.addDataSourceProperty( "cachePrepStmts" , "true" );
        hikariConfig.addDataSourceProperty( "prepStmtCacheSize" , "250" );
        hikariConfig.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
        //hikariConfig.addDataSourceProperty("maximumPoolSize", 10);
        return hikariConfig;
    }

    private Properties readConnectionProperties() {
        Properties properties = new Properties();
        try (InputStream fileInputStream = getClass().getResourceAsStream(PROPERTIES_PATH);) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

//    private Properties readHikariConfig() {
//
//    }
}
