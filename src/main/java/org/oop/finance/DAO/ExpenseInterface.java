package org.oop.finance.DAO;

import org.oop.finance.DTO.Expense;
import org.oop.finance.Exception.DAOException;

import java.sql.Date;
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

    /**
     * Add new expense.
     *
     * @throws DAOException the dao exception
     */
    public void addNewExpense(String expenseTitle, String expenseCategory, double expenseAmount, Date dateIncurred) throws DAOException;


    /**
     * Delete expense by id.
     *
     * @param expenseId the expense id
     * @throws DAOException the dao exception
     */
    public void deleteExpenseById(int expenseId) throws DAOException;
}
