package org.oop.finance.BusinessClasses;

import org.oop.finance.DAO.ExpenseDAO;
import org.oop.finance.DAO.ExpenseInterface;
import org.oop.finance.DAO.IncomeDAO;
import org.oop.finance.DAO.IncomeInterface;
import org.oop.finance.DTO.Expense;
import org.oop.finance.DTO.Income;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        IncomeInterface Iincomes = new IncomeDAO();
        ExpenseInterface IExpenses = new ExpenseDAO();

        try {
            System.out.println("\nFind All incomes: ");
            List<Income> incomes = Iincomes.getAllIncomes();

            if (incomes.isEmpty()) {
                System.out.println("No incomes found :(");
                System.exit(0);
            }
            System.out.println("List of incomes: " + incomes);

            System.out.println("------------------------------------------------------------------");

            System.out.println("\nFind all Expenses: ");
            List<Expense> expenses = IExpenses.getAllExpenses();

            if (expenses.isEmpty()) {
                System.out.println("No expenses found :(");
                System.exit(0);
            }
            System.out.println("List of expenses: " + expenses);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}