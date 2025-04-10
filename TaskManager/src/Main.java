import model.Manager;
import model.Task;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            int answerUser = scanner.nextInt();

            switch (answerUser) {
                case 1: {
                    System.out.println("Название задачи: ");
                    String name = scanner.next();

                    System.out.println("Описание задачи: ");
                    String description = scanner.next();

                    manager.crateTask(name, description);
                    System.out.println("Задачи создана успешно");
                    break;

                }
                case 2: {
                    System.out.println("Название задачи: ");
                    String name = scanner.next();

                    System.out.println("Описание задачи: ");
                    String description = scanner.next();

                    manager.crateEpic(name, description);
                    System.out.println("Задачи создана успешно");

                    break;


                }
                case 3: {
                    System.out.println("Введите идентификатор задачи для её удаления");
                    int id = scanner.nextInt();
                    manager.removeTaskById(id);
                    break;


                }
                case 4: {
                    System.out.println("Вы уверены что хотите удалить все задачи?");
                    String answer = scanner.nextLine();
                    if (answer == "да") {
                        manager.removeAllTask();
                        System.out.println("Все задачи удалены");
                    }
                    break;


                }
                case 5: {
                    System.out.println("Введите идентификатор задачи для её поиска");
                    int id = scanner.nextInt();
                    Task task = manager.findTask(id);
                    System.out.println("Найдена задача " + task.getName() + ". ");
                    System.out.println("Идентификатор задачи: " + task.getId());
                    System.out.println("Описание: " + task.getDescription());
                    System.out.println("Статус: " + task.getStatus());
                    System.out.println("Тип: " + task.getType());
                    System.out.println();
                    break;


                }
                case 6: {
                    manager.printAllTasks();
                    break;

                }
                default: {
                    System.out.println("Введена неверная команда");
                    return;
                }
            }
        }

    }


    public static void printMenu() {
        System.out.println("Введите команду (1-6): ");
        System.out.println("1. Создать задачу");
        System.out.println("2. Создать большую задачу");
        System.out.println("3. Удалить задачу по id");
        System.out.println("4. Удалить все задача");
        System.out.println("5. Найти задачу");
        System.out.println("6. Получение списка всех задач");
        System.out.println();
    }


}