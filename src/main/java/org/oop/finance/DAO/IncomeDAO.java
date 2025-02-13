package org.oop.finance.DAO;

import org.oop.finance.DTO.Income;
import org.oop.finance.Exception.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;


/**
 * The type Income dao.
 */
public class IncomeDAO extends DAO implements IncomeInterface {

    /**
     * List all incomes
     *
     * @return List<Income>
     * @throws DAOException Exception
     */
    @Override
    public List<Income> getAllIncomes() throws DAOException {
        List<Income> incomeList = new ArrayList<>();
        String query = "SELECT * FROM income";

        try (Connection conn = this.startConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Income income = new Income(
                        rs.getInt("income_id"),
                        rs.getString("income_title"),
                        rs.getDouble("income_amount"),
                        rs.getDate("date_earned")
                );
                incomeList.add(income);
            }
        } catch (SQLException ex) {
            throw new DAOException("ERROR: could not fetch incomes: " + ex.getMessage());
        }

        return incomeList;
    }

    /**
     * Add a new income
     *
     * @throws DAOException Exception
     */
    @Override
    public void addNewIncome(
            String incomeTitle,
            double incomeAmount,
            Date dateEarned
    ) throws DAOException {

        String query = "INSERT INTO income (income_title, income_amount, date_earned) VALUES (?,?,?)";

        try (Connection conn = this.startConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, incomeTitle);
            stmt.setDouble(2, incomeAmount);
            stmt.setDate(3, dateEarned);

            int rowsInserted = stmt.executeUpdate();

            if (rowsInserted == 0) {
                throw new DAOException("ERROR: no rows inserted :(");
            }

        } catch (SQLException ex) {
            throw new DAOException("ERROR: could not insert a new income: " + ex.getMessage());
        }
    }

    /**
     * Delete an income
     *
      * @param incomeId int
     * @throws DAOException Exception
     */
    @Override
    public void deleteIncomeById(int incomeId) throws DAOException{
        String query = "DELETE FROM income WHERE income_id = ?";

        try (Connection conn = this.startConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, incomeId);
            stmt.executeUpdate();

        } catch (SQLException ex) {
            throw new DAOException("ERROR: could not delete this income: " + ex.getMessage());
        }
    }
}
