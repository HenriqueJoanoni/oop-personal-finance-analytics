package org.oop.finance.DAO;

import org.oop.finance.DTO.Expense;
import org.oop.finance.Exception.DAOException;

import java.util.List;

/**
 * The interface Expense interface.
 */
public interface ExpenseInterface {

    /**
     * Gets all expenses.
     *
     * @return the all expenses
     * @throws DAOException the dao exception
     */
    public List<Expense> getAllExpenses() throws DAOException;
}
