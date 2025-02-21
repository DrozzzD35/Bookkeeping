import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Manager {
    private Map<Integer, YearlyStatistic> yearlyStatistics;

    public Manager() {
        this.yearlyStatistics = new HashMap<>();
    }

    public void verifyReports(int year) {
        if (!yearlyStatistics.containsKey(year)) {
            System.out.println("Отчётов по этому году не найдено");
            return;
        }
        YearlyStatistic yearlyStatistic = yearlyStatistics.get(year);
        YearlyReport yearlyReport = yearlyStatistic.getYearlyReport();
        double totalYearIncome = yearlyReport.getTotalIncome();
        double totalYearExpense = yearlyReport.getTotalExpense();

        List<MonthlyReport> monthlyReports = yearlyStatistic.getMonthlyReports();
        double totalMonthIncome = 0;
        double totalMonthExpense = 0;
        for (MonthlyReport report : monthlyReports) {
            totalMonthIncome += report.getTotalIncome();
            totalMonthExpense += report.getTotalExpense();
        }

        if (totalYearIncome == totalMonthIncome && totalYearExpense == totalMonthExpense) {
            System.out.println("Отчёты сходятся");
        } else {
            System.out.println("Ошибка. Отчёты не сходятся");
        }


    }

    public void readAllYearReports() {
        List<String> yearFilesName = getFileNameSByType(ReportType.YEARLY);
        System.out.println("Начали запись годовых отчетов");

        YearlyStatistic yearlyStatistic;

        for (String fileName : yearFilesName) {

            int year = defineYearByFileName(fileName);

            YearlyReport yearlyReport = new YearlyReport(year);

            List<String> rows = FileService.readFile(fileName);

            for (int i = 1; i < rows.size(); i++) {
                String row = rows.get(i);

                String[] strSplit = row.split(",");

                int monthNumber = Integer.parseInt(strSplit[0]);
                double amount = Double.parseDouble(strSplit[1]);
                boolean isExpense = Boolean.parseBoolean(strSplit[2]);

                YearlyReportItem yearlyReportItem = new YearlyReportItem(monthNumber, amount, isExpense);
                yearlyReport.addYearlyReports(yearlyReportItem);
            }

            if (yearlyStatistics.containsKey(year)) {
                yearlyStatistic = yearlyStatistics.get(year);
            } else {
                yearlyStatistic = new YearlyStatistic();
            }
            yearlyStatistic.setYearlyReport(yearlyReport);

        }

        System.out.println("Закончили запись годовых отчетов");
    }

    public void readAllMonthReports() {
        List<String> monthFilesName = getFileNameSByType(ReportType.MONTHLY);
        System.out.println("Начали запись месячных отчетов");
        YearlyStatistic yearlyStatistic;

        for (String fileName : monthFilesName) {

            int year = defineYearByFileName(fileName);
            int month = defineMonthByFileName(fileName);

            MonthlyReport monthlyReport = new MonthlyReport(month, year);
            List<String> rows = FileService.readFile(fileName);

            for (int i = 1; i < rows.size(); i++) {
                String row = rows.get(i);

                String[] strSplit = row.split(",");

                String itemName = strSplit[0];
                boolean isExpense = Boolean.parseBoolean(strSplit[1]);
                int quantity = Integer.parseInt(strSplit[2]);
                double unitPrice = Double.parseDouble(strSplit[3]);

                MonthlyReportItem monthlyReportItem = new MonthlyReportItem(itemName, isExpense, quantity, unitPrice);
                monthlyReport.addItems(monthlyReportItem);
            }

            if (yearlyStatistics.containsKey(year)) {
                yearlyStatistic = yearlyStatistics.get(year);
            } else {
                yearlyStatistic = new YearlyStatistic();
            }

            yearlyStatistic.setMonthlyReport(monthlyReport);
            yearlyStatistics.put(year, yearlyStatistic);
        }

        System.out.println("Закончили запись месячных отчетов");
    }

    public void printMonthReport(int year) {
        if (!yearlyStatistics.containsKey(year)) {
            System.out.println("Такого года не существует");
            return;
        }
        YearlyStatistic yearlyStatistic = yearlyStatistics.get(year);
        List<MonthlyReport> monthlyReports = yearlyStatistic.getMonthlyReports();

        for (MonthlyReport report : monthlyReports) {
            List<MonthlyReportItem> items = report.getItems();
            for (MonthlyReportItem item : items) {
                System.out.print("Позиция " + item.getItemName());
                System.out.print(". Тип операции " + partsExpense(item.getExpense()));
                System.out.print(". Количество " + item.getQuantity());
                System.out.print(". Стоимость " + item.getUnitPrice());
                System.out.println();
            }
        }

    }

    public void printYearReport(int year) {
        if (!yearlyStatistics.containsKey(year)) {
            System.out.println("Год не найден");
            return;
        }
        YearlyStatistic yearlyStatistic = yearlyStatistics.get(year);
        YearlyReport yearlyReport = yearlyStatistic.getYearlyReport();

        List<YearlyReportItem> yearlyReports = yearlyReport.getYearlyReportList();

        for (YearlyReportItem reportItem : yearlyReports) {
            System.out.print("Месяц " + reportItem.getMonthNumber());
            System.out.print(". Сумма " + reportItem.getAmount());
            System.out.print(". Тип операции " + partsExpense(reportItem.getIsExpense()));
            System.out.println();
        }

    }

    private String partsExpense(boolean isExpense) {
        return isExpense ? "расход" : "доход";
    }

    private int defineMonthByFileName(String fileName) {
        String[] parts = fileName.split("\\.");
        return Integer.parseInt(parts[1].substring(4, 6));
    }

    private int defineYearByFileName(String fileName) {
        String[] parts = fileName.split("\\.");
        return Integer.parseInt(parts[1].substring(0, 4));
    }

    private List<String> getFileNameSByType(ReportType type) {
        List<String> fileNames = new ArrayList<>();
        String nameStartWith = type == ReportType.MONTHLY ? "m." : "y.";
        try {
            fileNames = Files.walk(Paths.get("./resources"))
                    .filter(pathName -> {
                        String path = pathName.toString().toLowerCase(Locale.ROOT);
                        return (path.contains(nameStartWith)) && path.endsWith(".csv");
                    })
                    .map(file -> file.getFileName().toString())
                    .toList();
        } catch (Exception e) {
            System.out.println("Произошла ошибка при получении названии файлов");
        }
        return fileNames;
    }
}
