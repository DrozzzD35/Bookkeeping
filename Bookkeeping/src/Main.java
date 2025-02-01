import java.util.Scanner;

public class Main {


    /**
     * Классы: массивы(MRecord, YRecord), бизнес логика, enum{месяц, год}, месячный отчет, годовой отчет
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            System.out.println("Введите команду (1-6)");
            int command = scanner.nextInt();
            if (command==1){}
            if (command==2){}
            if (command==3){}
            if (command==4){}
            if (command==5){}
            if (command==6){return;}
        }

    }

    public static void printMenu(){
        System.out.println("1. Считать все месячные отчёты");
        System.out.println("2. Считать годовой отчёт");
        System.out.println("3. Сверить отчёты");
        System.out.println("4. Вывести информацию о месячных отчётах");
        System.out.println("5. Вывести информацию о годовом отчёте");
        System.out.println("6. Выйти");
        System.out.println();
    }
}