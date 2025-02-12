package org.oop.finance.DTO;

import java.sql.Date;
import java.util.List;

/**
 * The type Expense.
 */
public class Expense {
    private int expenseId;
    private String expenseTitle, expenseCategory;
    private double expenseAmount;
    private Date expenseDate;

    /**
     * Instantiates a new Expense.
     *
     * @param expenseId       integer
     * @param expenseTitle    String
     * @param expenseCategory String
     * @param expenseAmount   double
     * @param expenseDate     Date
     */
    public Expense(int expenseId, String expenseTitle, String expenseCategory, double expenseAmount, Date expenseDate) {
        this.expenseId = expenseId;
        this.expenseTitle = expenseTitle;
        this.expenseCategory = expenseCategory;
        this.expenseAmount = expenseAmount;
        this.expenseDate = expenseDate;
    }

    /**
     * Instantiates a new Expense.
     */
    public Expense() {
    }

    /**
     * Gets expense id.
     *
     * @return the expense id
     */
    public int getExpenseId() {
        return expenseId;
    }

    /**
     * Sets expense id.
     *
     * @param expenseId the expense id
     */
    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }

    /**
     * Gets expense title.
     *
     * @return the expense title
     */
    public String getExpenseTitle() {
        return expenseTitle;
    }

    /**
     * Sets expense title.
     *
     * @param expenseTitle the expense title
     */
    public void setExpenseTitle(String expenseTitle) {
        this.expenseTitle = expenseTitle;
    }

    /**
     * Gets expense category.
     *
     * @return the expense category
     */
    public String getExpenseCategory() {
        return expenseCategory;
    }

    /**
     * Sets expense category.
     *
     * @param expenseCategory the expense category
     */
    public void setExpenseCategory(String expenseCategory) {
        this.expenseCategory = expenseCategory;
    }

    /**
     * Gets expense amount.
     *
     * @return the expense amount
     */
    public double getExpenseAmount() {
        return expenseAmount;
    }

    /**
     * Sets expense amount.
     *
     * @param expenseAmount the expense amount
     */
    public void setExpenseAmount(double expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    /**
     * Gets expense date.
     *
     * @return the expense date
     */
    public Date getExpenseDate() {
        return expenseDate;
    }

    /**
     * Sets expense date.
     *
     * @param expenseDate the expense date
     */
    public void setExpenseDate(Date expenseDate) {
        this.expenseDate = expenseDate;
    }

    /**
     * Calculate total spend double.
     *
     * @param expenseList the expense list
     * @return the double
     */
    public double calculateTotalSpend(List<Expense> expenseList) {
        double totalValue = 0;
        for (Expense expense : expenseList) {
            totalValue += expense.getExpenseAmount();
        }
        return totalValue;
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Title: %s | Category: %s | Amount: %.2f | Date: %s",
                expenseId, expenseTitle, expenseCategory, expenseAmount, expenseDate);
    }
}
