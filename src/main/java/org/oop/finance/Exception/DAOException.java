package org.oop.finance.Exception;

import java.sql.SQLException;

/**
 * The type Dao exception.
 */
public class DAOException extends SQLException {
    /**
     * Instantiates a new Dao exception.
     *
     * @param message the message
     */
    public DAOException(String message) {
        super(message);
    }
}
