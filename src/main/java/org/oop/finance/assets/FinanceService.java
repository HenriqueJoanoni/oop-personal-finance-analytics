package org.oop.finance.assets;

import org.oop.finance.DAO.ExpenseDAO;
import org.oop.finance.DAO.IncomeDAO;
import org.oop.finance.DTO.Expense;
import org.oop.finance.DTO.Income;
import org.oop.finance.Exception.DAOException;

import java.util.List;

/**
 * The type Finance service.
 */
public class FinanceService {
    private IncomeDAO incomeDAO;
    private ExpenseDAO expenseDAO;

    /**
     * Instantiates a new Finance service.
     *
     * @param incomeDAO  the income dao
     * @param expenseDAO the expense dao
     */
    public FinanceService(IncomeDAO incomeDAO, ExpenseDAO expenseDAO) {
        this.incomeDAO = incomeDAO;
        this.expenseDAO = expenseDAO;
    }

    /**
     * Show monthly report.
     *
     * @param month the month
     * @param year  the year
     * @throws DAOException the dao exception
     */
    public void showMonthlyReport(int month, int year) throws DAOException {
        List<Income> incomes = incomeDAO.getIncomesByMonth(month, year);
        List<Expense> expenses = expenseDAO.getExpensesByMonth(month, year);

        double totalIncome = incomes.stream().mapToDouble(Income::getIncomeAmount).sum();
        double totalExpenses = expenses.stream().mapToDouble(Expense::getExpenseAmount).sum();
        double balance = totalIncome - totalExpenses;

        System.out.println("\n=== Financial Report for " + month + "/" + year + " ===");
        System.out.println("\nIncomes:");
        for (Income income : incomes) {
            System.out.println("- " + income.getIncomeTitle() + ": €" + income.getIncomeAmount());
        }

        System.out.println("\nExpenses:");
        for (Expense expense : expenses) {
            System.out.println("- " + expense.getExpenseTitle() + ": €" + expense.getExpenseAmount());
        }

        System.out.println("\nTotal Income: €" + totalIncome);
        System.out.println("Total Expenses: €" + totalExpenses);
        System.out.println("Remaining Balance: €" + balance);
    }
}

