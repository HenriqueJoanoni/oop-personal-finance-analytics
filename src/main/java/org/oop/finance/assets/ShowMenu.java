package org.oop.finance.assets;

import org.oop.finance.DAO.ExpenseDAO;
import org.oop.finance.DAO.ExpenseInterface;
import org.oop.finance.DAO.IncomeDAO;
import org.oop.finance.DAO.IncomeInterface;
import org.oop.finance.DTO.Expense;
import org.oop.finance.DTO.Income;
import org.oop.finance.Exception.DAOException;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class ShowMenu {

    public void displayMenu() throws DAOException, ParseException {
        Scanner sc = new Scanner(System.in);

        /** EXPENSES */
        ExpenseInterface IExpenses = new ExpenseDAO();
        Expense exp = new Expense();
        List<Expense> expenses;

        /** INCOMES */
        IncomeInterface IIncome = new IncomeDAO();
        Income inc = new Income();
        List<Income> incomes;

        /** UTILS */
        Utils dateFormat = new Utils();
        Utils displayExpTable = new Utils();
        Utils displayIncTable = new Utils();
        int userChoice;

        System.out.println("""
                Please choose one of the options below: \n
                1. List All Expenses
                2. Add a New Expense
                3. Delete an Expense by ID
                4. List All Income Earned
                5. Add A New Income
                6. Delete an Income by ID
                7. List all Income and Expenses by Date
                """);

        userChoice = sc.nextInt();

        switch (userChoice) {
            case 1:
                System.out.println("\nFind all Expenses -> ");
                expenses = IExpenses.getAllExpenses();

                if (expenses.isEmpty()) {
                    System.out.println("No expenses found :(");
                    return;
                }

                double totalValue = exp.calculateTotalSpend(expenses);

                System.out.println("List of expenses: ");
                displayExpTable.printExpenseTable(expenses);


                System.out.println("TOTAL VALUE: € " + totalValue);
                displayMenu();
                break;
            case 2:
                System.out.println("\nAdd new Expense -> ");
                sc.nextLine();

                System.out.println("\nGive your expense a title: ");
                String expenseTitle = sc.nextLine();

                System.out.println("\nAdd a category for this expense: ");
                String expenseCategory = sc.nextLine();

                System.out.println("\nWhat's the amount? ");
                double expenseAmount = sc.nextDouble();
                sc.nextLine();

                System.out.println("\nWhich date was this expense made? (DD/MM/YYYY)");
                String userDateInput = sc.nextLine();

                IExpenses.addNewExpense(expenseTitle, expenseCategory, expenseAmount, dateFormat.formatDate(userDateInput));

                displayExpTable.printExpenseTable(IExpenses.getAllExpenses());
                displayMenu();
                break;
            case 3:
                System.out.println("\nDelete expense -> ");

                System.out.println("\nType the id of an expense you want do delete: ");
                int deleteExpense = sc.nextInt();

                IExpenses.deleteExpenseById(deleteExpense);
                displayExpTable.printExpenseTable(IExpenses.getAllExpenses());
                displayMenu();
                break;
            case 4:
                System.out.println("\nList all incomes: ");
                incomes = IIncome.getAllIncomes();

                if (incomes.isEmpty()) {
                    System.out.println("No incomes found :(");
                    return;
                }

                double totalIncomeValue = inc.calculateTotalEarned(incomes);

                System.out.println("List of Incomes: ");
                displayIncTable.printIncomeTable(incomes);

                System.out.println("TOTAL INCOME EARNED: € " + totalIncomeValue);
                displayMenu();
                break;
            case 5:
                System.out.println("\nAdd new income ->");
                sc.nextLine();

                System.out.println("\nGive your income a title: ");
                String incomeTitle = sc.nextLine();

                System.out.println("\nWhat's the amount? ");
                double incomeAmount = sc.nextDouble();
                sc.nextLine();

                System.out.println("\nWhich date this income was earned? (DD/MM/YYY)");
                String incomeDateEarned = sc.nextLine();

                IIncome.addNewIncome(incomeTitle, incomeAmount, dateFormat.formatDate(incomeDateEarned));

                displayIncTable.printIncomeTable(IIncome.getAllIncomes());
                displayMenu();
                break;
            case 6:
                System.out.println("\nDelete Income -> ");

                System.out.println("\nType the id of the income you want do delete: ");
                int deleteIncome = sc.nextInt();

                IIncome.deleteIncomeById(deleteIncome);
                displayIncTable.printIncomeTable(IIncome.getAllIncomes());
                displayMenu();
                break;
            case 7:
                System.out.println("\nShow all incomes and expenses by month ->");
                System.out.println("\nEnter a month (1-12): ");
                int month = sc.nextInt();

                System.out.println("\nEnter a year: ");
                int year = sc.nextInt();

                FinanceService financeService = new FinanceService(new IncomeDAO(), new ExpenseDAO());
                financeService.showMonthlyReport(month, year);
                break;
            default:
                System.out.println("Invalid Option, please try again");
                displayMenu();
        }
    }
}
