import java.util.ArrayList;
import java.util.List;

public class MArchiveReport {
    List<MRecord> mReportList = new ArrayList<>();

    MArchiveReport(){}

    public void addReportMonths(MRecord mRecord) {
        mReportList.add(mRecord);
    }

    public void removeReportMonths(MRecord mRecord) {
        mReportList.remove(mRecord);
    }

    public void printAllMReport() {
        for (MRecord mRecord : mReportList) {
            if (mRecord.checkMReport()) {
                System.out.println("Название товара: " + mRecord.getItem_name());
                System.out.println("Приобретён товар?" + mRecord.getIs_expense());
                System.out.println("Количество товара: " + mRecord.getQuantity());
                System.out.println("Стоимость одного товара: " + mRecord.getSum_of_one());
                System.out.println();
            }
        }

    }
}


