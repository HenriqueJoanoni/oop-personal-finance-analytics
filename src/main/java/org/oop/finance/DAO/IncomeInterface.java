package org.oop.finance.DAO;

import org.oop.finance.DTO.Income;
import org.oop.finance.Exception.DAOException;

import java.sql.Date;
import java.util.List;

/**
 * The interface Income interface.
 */
public interface IncomeInterface {

    /**
     * Gets all incomes.
     *
     * @return the all incomes
     * @throws DAOException the dao exception
     */
    public List<Income> getAllIncomes() throws DAOException;

    /**
     * Add new income.
     *
     * @throws DAOException the dao exception
     */
    public void addNewIncome(String incomeTitle, double incomeAmount, Date dateEarned) throws DAOException;

    /**
     * Delete income by id.
     *
     * @param incomeId the income id
     * @throws DAOException the dao exception
     */
    public void deleteIncomeById(int incomeId) throws DAOException;
}
