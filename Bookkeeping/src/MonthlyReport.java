import java.util.ArrayList;
import java.util.List;

public class MonthlyReport {
    private int month;
    private int year;
    private List<MonthlyReportItem> items = new ArrayList<>();

    public MonthlyReport(int month, int year) {
        this.month = month;
        this.year = year;
    }

    public MonthlyReport(){}

    public double getTotalIncome() {
        double totalSum = 0;
        for (MonthlyReportItem item : items) {
            if (!item.getExpense()) {
                totalSum += item.getQuantity() * item.getUnitPrice();
            }
        }
        return totalSum;
    }

    public double getTotalExpense() {
        double totalSum = 0;
        for (MonthlyReportItem item : items) {
            if (item.getExpense()) {
                totalSum += item.getQuantity() * item.getUnitPrice();
            }
        }
        return totalSum;
    }

    public void addItems(MonthlyReportItem item) {
        this.items.add(item);
    }

    public List<MonthlyReportItem> getItems() {
        return items;
    }

}


