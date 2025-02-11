package org.oop.finance.DTO;

import java.util.Date;

/**
 * The type Income.
 */
public class Income {
    private int incomeId;
    private String incomeTitle;
    private double incomeAmount;
    private Date dateEarned;

    /**
     * Instantiates a new Income.
     *
     * @param incomeId     the income id
     * @param incomeTitle  the income title
     * @param incomeAmount the income amount
     * @param dateEarned   the date earned
     */
    public Income(int incomeId, String incomeTitle, double incomeAmount, Date dateEarned) {
        this.incomeId = incomeId;
        this.incomeTitle = incomeTitle;
        this.incomeAmount = incomeAmount;
        this.dateEarned = dateEarned;
    }

    /**
     * Instantiates a new Income.
     */
    public Income() {
    }

    /**
     * Gets income id.
     *
     * @return the income id
     */
    public int getIncomeId() {
        return incomeId;
    }

    /**
     * Sets income id.
     *
     * @param incomeId the income id
     */
    public void setIncomeId(int incomeId) {
        this.incomeId = incomeId;
    }

    /**
     * Gets income title.
     *
     * @return the income title
     */
    public String getIncomeTitle() {
        return incomeTitle;
    }

    /**
     * Sets income title.
     *
     * @param incomeTitle the income title
     */
    public void setIncomeTitle(String incomeTitle) {
        this.incomeTitle = incomeTitle;
    }

    /**
     * Gets income amount.
     *
     * @return the income amount
     */
    public double getIncomeAmount() {
        return incomeAmount;
    }

    /**
     * Sets income amount.
     *
     * @param incomeAmount the income amount
     */
    public void setIncomeAmount(double incomeAmount) {
        this.incomeAmount = incomeAmount;
    }

    /**
     * Gets date earned.
     *
     * @return the date earned
     */
    public Date getDateEarned() {
        return dateEarned;
    }

    /**
     * Sets date earned.
     *
     * @param dateEarned the date earned
     */
    public void setDateEarned(Date dateEarned) {
        this.dateEarned = dateEarned;
    }

    @Override
    public String toString() {
        return String.format(
                "Income Details:\n" +
                        "- ID: %d\n" +
                        "- Title: %s\n" +
                        "- Amount: $%.2f\n" +
                        "- Date Earned: %s\n",
                incomeId, incomeTitle, incomeAmount, dateEarned
        );
    }
}
