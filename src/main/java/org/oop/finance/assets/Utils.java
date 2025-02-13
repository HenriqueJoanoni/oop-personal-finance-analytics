package org.oop.finance.assets;

import org.oop.finance.DTO.Expense;
import org.oop.finance.DTO.Income;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class Utils {

    /**
     * Format dates to database input
     *
     * @param userDateInput string
     * @return java.sql.Date
     * @throws ParseException Exception
     */
    public Date formatDate(String userDateInput) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        java.util.Date utilDate = dateFormat.parse(userDateInput);
        java.sql.Date dateIncurred = new java.sql.Date(utilDate.getTime());

        return dateIncurred;
    }

    /**
     * Print expense table.
     *
     * @param expenses the expenses
     */
    public void printExpenseTable(List<Expense> expenses) {
        System.out.println("+-------+----------------------+-----------------+------------+------------+");
        System.out.println("| ID    | Title                | Category        | Amount (€) | Date       |");
        System.out.println("+-------+----------------------+-----------------+------------+------------+");

        for (Expense expense : expenses) {
            System.out.println(expense);
        }

        System.out.println("+-------+----------------------+-----------------+------------+------------+");
    }

    /**
     * Print income table.
     *
     * @param incomes the incomes
     */
    public void printIncomeTable(List<Income> incomes) {
        System.out.println("+-------+---------------------------+------------+------------+");
        System.out.println("| ID    | Title                     | Amount (€) | Date       |");
        System.out.println("+-------+---------------------------+------------+------------+");

        for (Income income : incomes) {
            System.out.println(income);
        }

        System.out.println("+-------+---------------------------+------------+------------+");
    }
}
