package org.oop.finance.DAO;

import org.oop.finance.DTO.Income;
import org.oop.finance.Exception.DAOException;

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
}
