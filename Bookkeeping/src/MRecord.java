import java.util.ArrayList;
import java.util.List;

public class MRecord {
    private String item_name;
    private boolean is_expense;
    private int sum_of_one;
    private int quantity;

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public boolean getIs_expense() {
        return is_expense;
    }

    public void setIs_expense(boolean is_expense) {
        this.is_expense = is_expense;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSum_of_one() {
        return sum_of_one;
    }

    public void setSum_of_one(int sum_of_one) {
        this.sum_of_one = sum_of_one;
    }

    public MRecord(String item_name, boolean is_expense, int quantity, int sum_of_one) {
        setItem_name(item_name);
        setIs_expense(is_expense);
        setQuantity(quantity);
        setSum_of_one(sum_of_one);
    }

    public boolean checkMReport() {
        if (item_name.isEmpty()) {
            System.out.println("Имя не может быть пустым");
            return false;
        } else if (quantity <= 0) {
            System.out.println("Количество не может иметь отрицательное или нулевое значение");
            return false;
        } else if (sum_of_one <= 0) {
            System.out.println("Сумма не может иметь отрицательное или нулевое значение");
            return false;
        }
        return true;
    }

}






