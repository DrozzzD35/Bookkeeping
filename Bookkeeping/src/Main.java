import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Manager manager = new Manager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println();
            printMenu();
            System.out.println("Введите команду (1-6)");
            int number = scanner.nextInt();
            Command command = Command.getCommand(number);

            switch (command) {
                case READ_MONTH_REPORTS -> manager.readAllMonthReports();
                case READ_YEAR_REPORTS -> manager.readAllYearReports();
                case VERIFY_REPORTS -> {
                    System.out.println("Введите год проверки");
                    manager.verifyReports(scanner.nextInt());
                }
                case PRINT_MONTH_REPORTS -> {
                    System.out.println("Введите год вывода");
                    manager.printMonthReport(scanner.nextInt());
                }
                case PRINT_YEAR_REPORTS -> {
                    System.out.println("Введите год вывода");
                    manager.printYearReport(scanner.nextInt());
                }
                case EXIT -> {
                    System.out.println("Завершение работы программы");
                    return;
                }
            }
        }
    }

    public static void printMenu() {
        System.out.println("1. Считать все месячные отчёты");
        System.out.println("2. Считать годовой отчёт");
        System.out.println("3. Сверить отчёты");
        System.out.println("4. Вывести информацию о месячных отчётах");
        System.out.println("5. Вывести информацию о годовом отчёте");
        System.out.println("6. Выйти");
        System.out.println();
    }

}
