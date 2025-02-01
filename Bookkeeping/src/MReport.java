public class MReport {
    public void MReport() {
        MRecord konki = new MRecord("Коньки", true, 50, 2000);
        MRecord elka = new MRecord("Новогодняя ёлка", true, 1, 100000);
        MRecord larekWithCoffee = new MRecord("Ларёк с кофе", true, 3, 50000);
        MRecord arendaKonkof = new MRecord("Аренда коньков", false, 1000, 180);
        MRecord prodBiletof = new MRecord("Продажа билетов", false, 3500, 300);
        MRecord prodCoffee = new MRecord("Продажа кофе", false, 2421, 150);

        MArchiveReport mArchiveReport = new MArchiveReport();
        mArchiveReport.addReportMonths(konki);
        mArchiveReport.addReportMonths(elka);
        mArchiveReport.addReportMonths(larekWithCoffee);
        mArchiveReport.addReportMonths(arendaKonkof);
        mArchiveReport.addReportMonths(prodBiletof);
        mArchiveReport.addReportMonths(prodCoffee);

        mArchiveReport.printAllMReport();
    }
}


