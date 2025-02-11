package org.oop.finance.DAO;

import org.oop.finance.Exception.DAOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The type Dao.
 */
public class DAO {
    /**
     * Start connection.
     *
     * @return the connection
     * @throws DAOException the dao exception
     */
    public Connection startConnection() throws DAOException {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/finance_analytics";
        String username = "root";
        String password = "";
        Connection conn = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            System.out.println("Failed to find driver class " + e.getMessage());
            System.exit(1);
        } catch (SQLException e) {
            System.out.println("Connection failed " + e.getMessage());
            System.exit(2);
        }
        return conn;
    }

    /**
     * Stop connection.
     *
     * @param conn the connection object
     * @throws DAOException the dao exception
     */
    public void stopConnection(Connection conn) throws DAOException {
        try {
            if (conn != null) {
                conn.close();
                conn = null;
            }
        } catch (SQLException e) {
            System.out.println("Failed to free connection: " + e.getMessage());
            System.exit(1);
        }
    }
}
