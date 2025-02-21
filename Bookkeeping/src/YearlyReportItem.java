public class YearlyReportItem {
    private int monthNumber;
    private double amount;
    private boolean isExpense;


    public YearlyReportItem(int monthNumber, double amount, boolean isExpense) {
        setAmount(amount);
        setIsExpense(isExpense);
        setMonthNumber(monthNumber);
    }

    public int getMonthNumber() {
        return monthNumber;
    }

    public void setMonthNumber(int monthNumber) {
        this.monthNumber = monthNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean getIsExpense() {
        return isExpense;
    }

    public void setIsExpense(boolean isExpense) {
        this.isExpense = isExpense;
    }


}
