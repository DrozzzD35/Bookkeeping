import java.util.ArrayList;
import java.util.List;

public class YearlyStatistic {

    private YearlyReport yearlyReport;
    private List<MonthlyReport> monthlyReports = new ArrayList<>();

    public YearlyReport getYearlyReport() {
        return yearlyReport;
    }

    public void setYearlyReport(YearlyReport yearlyReport) {
        this.yearlyReport = yearlyReport;
    }

    public List<MonthlyReport> getMonthlyReports() {
        return monthlyReports;
    }


    public void setMonthlyReport(MonthlyReport monthlyReport) {
        if (!monthlyReports.contains(monthlyReport)) {
            this.monthlyReports.add(monthlyReport);
        }
    }


}
