package org.oop.finance.DAO;

import org.oop.finance.DTO.Expense;
import org.oop.finance.Exception.DAOException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Expense dao.
 */
public class ExpenseDAO extends DAO implements ExpenseInterface {

    /**
     * Get all expenses
     *
     * @return List<Expense>
     * @throws DAOException Exception
     */
    @Override
    public List<Expense> getAllExpenses() throws DAOException {
        List<Expense> expenseList = new ArrayList<>();
        String query = "SELECT * FROM expense";

        try (Connection conn = this.startConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Expense expense = new Expense(
                        rs.getInt("expense_id"),
                        rs.getString("expense_title"),
                        rs.getString("expense_category"),
                        rs.getDouble("expense_amount"),
                        rs.getDate("date_incurred")
                );
                expenseList.add(expense);
            }
        } catch (SQLException ex) {
            throw new DAOException("ERROR: could not fetch expenses: " + ex.getMessage());
        }

        return expenseList;
    }

    /**
     * Add a new expense
     *
     * @param expenseTitle    String
     * @param expenseCategory String
     * @param expenseAmount   double
     * @param dateIncurred    Date (java.sql)
     * @throws DAOException Exception
     */
    @Override
    public void addNewExpense(
            String expenseTitle,
            String expenseCategory,
            double expenseAmount,
            Date dateIncurred
    ) throws DAOException {

        String query = "INSERT INTO expense (expense_title, expense_category,expense_amount, date_incurred) VALUES (?,?,?,?)";

        try (Connection conn = this.startConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, expenseTitle);
            stmt.setString(2, expenseCategory);
            stmt.setDouble(3, expenseAmount);
            stmt.setDate(4, dateIncurred);

            int rowsInserted = stmt.executeUpdate();

            if (rowsInserted == 0) {
                throw new DAOException("ERROR: no rows inserted: ");
            }

        } catch (SQLException ex) {
            throw new DAOException("ERROR: could not insert a new expense: " + ex.getMessage());
        }
    }

    /**
     * Delete an expense by id
     *
     * @param expenseId expense id
     * @throws DAOException Exception
     */
    @Override
    public void deleteExpenseById(int expenseId) throws DAOException {
        String query = "DELETE FROM expense WHERE expense_id = ?";

        try (Connection conn = this.startConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, expenseId);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException("ERROR: could not delete this expense: " + ex.getMessage());
        }
    }
}
