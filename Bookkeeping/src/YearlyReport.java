import java.util.ArrayList;
import java.util.List;

public class YearlyReport {
    private List<YearlyReportItem> yearlyReportList = new ArrayList<>();
    private int year;

    YearlyReport(){}

    public YearlyReport(List<YearlyReportItem> yearlyReportList) {
        this.yearlyReportList = yearlyReportList;
    }

    public List<YearlyReportItem> getYearlyReportList() {
        return yearlyReportList;
    }

    public YearlyReport(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }



    public double getTotalIncome() {
        double totalSum = 0;
        for (YearlyReportItem item : yearlyReportList) {
            if (!item.getIsExpense()) {
                totalSum += item.getAmount();
            }
        }
        return totalSum;
    }

    public double getTotalExpense() {
        double totalSum = 0;
        for (YearlyReportItem item : yearlyReportList) {
            if (item.getIsExpense())
                totalSum += item.getAmount();
        }
        return totalSum;
    }

    public void addYearlyReports(YearlyReportItem yearlyReport) {
        this.yearlyReportList.add(yearlyReport);
    }
}
