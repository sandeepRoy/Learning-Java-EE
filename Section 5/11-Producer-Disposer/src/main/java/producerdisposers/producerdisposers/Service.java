package producerdisposers.producerdisposers;

import jakarta.annotation.Resource;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RequestScoped
public class Service {
    @Resource(name = "java:comp/env/jdbc/MyDataSource")
    private DataSource dataSource;

    @Produces
    @RequestScoped
    public Connection produceConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public void disposeConnection(@Disposes Connection connection) {
        try {
            if(connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String disposeConnectionManually(Connection connection) {
        disposeConnection(connection);
        return "Connection Disposed";
    }
}
