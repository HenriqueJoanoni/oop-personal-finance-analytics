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
        DateUtil dateFormat = new DateUtil();
        int userChoice;

        System.out.println("""
                
                
                d8888b. d88888b d8888b. .d8888.  .d88b.  d8b   db  .d8b.  db     \s
                88  `8D 88'     88  `8D 88'  YP .8P  Y8. 888o  88 d8' `8b 88     \s
                88oodD' 88ooooo 88oobY' `8bo.   88    88 88V8o 88 88ooo88 88     \s
                88~~~   88~~~~~ 88`8b     `Y8b. 88    88 88 V8o88 88~~~88 88     \s
                88      88.     88 `88. db   8D `8b  d8' 88  V888 88   88 88booo.\s
                88      Y88888P 88   YD `8888Y'  `Y88P'  VP   V8P YP   YP Y88888P\s
                                                                                 \s
                                                                                 \s
                d88888b d888888b d8b   db  .d8b.  d8b   db  .o88b. d88888b .d8888.
                88'       `88'   888o  88 d8' `8b 888o  88 d8P  Y8 88'     88'  YP
                88ooo      88    88V8o 88 88ooo88 88V8o 88 8P      88ooooo `8bo. \s
                88~~~      88    88 V8o88 88~~~88 88 V8o88 8b      88~~~~~   `Y8b.
                88        .88.   88  V888 88   88 88  V888 Y8b  d8 88.     db   8D
                YP      Y888888P VP   V8P YP   YP VP   V8P  `Y88P' Y88888P `8888Y'
                
                """);

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
                expenses.forEach(System.out::println);

                System.out.println("TOTAL VALUE: " + totalValue);
                break;
            case 2:
                // TODO: BUG ON THIS FEATURE CHECK LATER
                System.out.println("\nAdd new Expense -> ");

                System.out.println("\nGive your expense a title: ");
                String expenseTitle = sc.nextLine();
                sc.nextLine();

                System.out.println("\nAdd a category for this expense: ");
                String expenseCategory = sc.nextLine();

                System.out.println("\nWhat's the amount? ");
                double expenseAmount = sc.nextDouble();

                System.out.println("\nWhich date this expense was made? (DD/MM/YYY)");
                sc.nextLine();
                String userDateInput = sc.nextLine();

                IExpenses.addNewExpense(expenseTitle, expenseCategory, expenseAmount, dateFormat.formatDate(userDateInput));

                System.out.println("\nDisplaying all expenses: " + IExpenses.getAllExpenses());
                break;
            case 3:
                System.out.println("\nDelete expense -> ");

                System.out.println("\nType the id of an expense you want do delete: ");
                int deleteExpense = sc.nextInt();

                IExpenses.deleteExpenseById(deleteExpense);
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
                incomes.forEach(System.out::println);

                System.out.println("TOTAL INCOME EARNED: " + totalIncomeValue);
                break;
            case 5:
                // TODO: BUG ON THIS FEATURE CHECK LATER
                System.out.println("\nAdd new income ->");

                System.out.println("\nGive your income a title: ");
                String incomeTitle = sc.nextLine();
                sc.nextLine();

                System.out.println("\nWhat's the amount? ");
                double incomeAmount = sc.nextDouble();

                System.out.println("\nWhich date this income was earned? (DD/MM/YYY)");
                sc.nextLine();
                String incomeDateEarned = sc.nextLine();

                IIncome.addNewIncome(incomeTitle, incomeAmount, dateFormat.formatDate(incomeDateEarned));

                System.out.println("\nDisplaying all expenses: " + IIncome.getAllIncomes());
                break;
            case 6:
                System.out.println("\nDelete Income -> ");

                System.out.println("\nType the id of the income you want do delete: ");
                int deleteIncome = sc.nextInt();

                IIncome.deleteIncomeById(deleteIncome);
                break;
            case 7:
                break;
            default:
                System.out.println("Invalid Option, please try again");
                displayMenu();
        }
    }
}
