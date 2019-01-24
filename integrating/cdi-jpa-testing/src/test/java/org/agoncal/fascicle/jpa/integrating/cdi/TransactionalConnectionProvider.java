package org.agoncal.fascicle.jpa.integrating.cdi;

import com.arjuna.ats.jdbc.TransactionalDriver;
import org.h2.jdbcx.JdbcDataSource;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.service.UnknownUnwrapTypeException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author <a href="mailto:gytis@redhat.com">Gytis Trikleris</a>
 */
public class TransactionalConnectionProvider implements ConnectionProvider {

    public static final String DATASOURCE_JNDI = "java:testDS";
    public static final String USERNAME = "sa";
    public static final String PASSWORD = "";

    private final TransactionalDriver transactionalDriver;

    public TransactionalConnectionProvider() {
        transactionalDriver = new TransactionalDriver();
    }

    public static void bindDataSource() {
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setURL("jdbc:h2:mem:db1;DB_CLOSE_DELAY=-1");
        dataSource.setUser(USERNAME);
        dataSource.setPassword(PASSWORD);

        try {
            InitialContext initialContext = new InitialContext();
            initialContext.bind(DATASOURCE_JNDI, dataSource);
        }
        catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        Properties properties = new Properties();
        properties.setProperty(TransactionalDriver.userName, USERNAME);
        properties.setProperty(TransactionalDriver.password, PASSWORD);
        return transactionalDriver.connect("jdbc:arjuna:" + DATASOURCE_JNDI, properties);
    }

    @Override
    public void closeConnection(Connection connection) throws SQLException {
        if (!connection.isClosed()) {
            connection.close();
        }
    }

    @Override
    public boolean supportsAggressiveRelease() {
        return false;
    }

    @Override
    public boolean isUnwrappableAs(Class aClass) {
        return getClass().isAssignableFrom(aClass);
    }

    @Override
    public <T> T unwrap(Class<T> aClass) {
        if (isUnwrappableAs(aClass)) {
            return (T) this;
        }

        throw new UnknownUnwrapTypeException(aClass);
    }
}
