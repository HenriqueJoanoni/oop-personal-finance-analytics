package org.oop.finance.DAO;

import org.oop.finance.DTO.Expense;
import org.oop.finance.Exception.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The type Expense dao.
 */
public class ExpenseDAO extends DAO implements ExpenseInterface {

    /**
     *
     * @return List<Expense>
     * @throws DAOException Exception
     */
    @Override
    public List<Expense> getAllExpenses() throws DAOException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Expense> expenseList = new ArrayList<>();

        try {
            conn = this.startConnection();

            String query = "SELECT * FROM expense";
            stmt = conn.prepareStatement(query);

            rs = stmt.executeQuery();
            while (rs.next()) {
                int expenseId = rs.getInt("expense_id");
                String expenseTitle = rs.getNString("expense_title");
                String expenseCategory = rs.getNString("expense_category");
                double expenseAmount = rs.getDouble("expense_amount");
                Date dateIncurred = rs.getDate("date_incurred");

                Expense expense = new Expense(expenseId, expenseTitle, expenseCategory, expenseAmount, dateIncurred);
                expenseList.add(expense);
            }
        } catch (SQLException ex) {
            throw new DAOException("getAllExpenses() " + ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    stopConnection(conn);
                }
            } catch (SQLException ex) {
                throw new DAOException("getAllExpenses() " + ex.getMessage());
            }
        }
        return expenseList;
    }
}
