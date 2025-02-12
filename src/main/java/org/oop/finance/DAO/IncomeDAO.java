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
     *
     * @return List<Income>
     * @throws DAOException Exception
     */
    @Override
    public List<Income> getAllIncomes() throws DAOException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Income> incomeList = new ArrayList<>();

        try {
            conn = this.startConnection();

            String query = "SELECT * FROM income";
            stmt = conn.prepareStatement(query);

            rs = stmt.executeQuery();
            while (rs.next()) {
                int incomeId = rs.getInt("income_id");
                String incomeTitle = rs.getNString("income_title");
                double incomeAmount = rs.getDouble("income_amount");
                Date date = rs.getDate("date_earned");

                Income income = new Income(incomeId, incomeTitle, incomeAmount, date);
                incomeList.add(income);
            }
        } catch (SQLException ex) {
            throw new DAOException("getAllIncomes() " + ex.getMessage());
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
                throw new DAOException("getAllIncomes() " + ex.getMessage());
            }
        }
        return incomeList;
    }
}
