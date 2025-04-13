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
                    System.out.println("1. Создать задачу");
                    System.out.println("2. Создать большую задачу");
                    System.out.println("3. Создать подзадачу");
                    int answer = scanner.nextInt();

                    if (answer == 1) {
                        System.out.println("Название задачи: ");
                        String name = scanner.next();

                        System.out.println("Описание задачи: ");
                        String description = scanner.next();

                        manager.crateTask(name, description);
                        System.out.println("Задачи создана успешно");
                        System.out.println();
                    } else if (answer == 2) {
                        System.out.println("Название задачи: ");
                        String name = scanner.next();

                        System.out.println("Описание задачи: ");
                        String description = scanner.next();

                        manager.crateEpic(name, description);
                        System.out.println("Большая задачи создана успешно");
                        System.out.println();
                    } else if (answer == 3) {
                        System.out.println("Название задачи: ");
                        String name = scanner.next();

                        System.out.println("Описание задачи: ");
                        String description = scanner.next();

                        manager.crateSubTask(name, description);
                        System.out.println("Подзадачи создана успешно");
                        System.out.println();
                    } else {
                        System.out.println("Неверно указана команда");
                    }

                    break;
                }
                case 3: {
                    System.out.println("Введите идентификатор задачи для её удаления");
                    int id = scanner.nextInt();
                    manager.removeTaskById(id);
                    System.out.println();
                    break;
                }
                case 4: {
                    System.out.println("Вы уверены что хотите удалить все задачи?");
                    System.out.println("1. Да");
                    System.out.println("2. Нет");
                    int answer = scanner.nextInt();
                    if (answer == 1) {
                        manager.removeAllTask();
                        System.out.println("Все задачи удалены");

                    } else {
                        System.out.println("Задачи не удалены");
                    }
                    System.out.println();

                    break;
                }
                case 5: {
                    System.out.println("Введите идентификатор задачи для её поиска");
                    int id = scanner.nextInt();
                    manager.printTask(id);
                    System.out.println();
                    break;
                }
                case 6: {
                    manager.printAllTasks();
                    break;

                }
                case 7: {

                    System.out.println("Введите идентификатор задачи: ");
                    int id = scanner.nextInt();
                    Task task = manager.findTask(id);
                    manager.printTask(id);

                    System.out.println("1. Изменить имя задачи");
                    System.out.println("2. Изменить описание задачи");
                    System.out.println("3. Изменить статус задачи");
                    int answer = scanner.nextInt();


                    if (answer == 1) {
                        System.out.println("Какое имя вы хотели бы присвоить");
                        String name = scanner.next();
                        manager.updateName(task, name);
                        System.out.println("Имя задачи успешно изменено на " + name);
                        System.out.println();
                        manager.printTask(id);
                        break;
                    } else if (answer == 2) {
                        System.out.println("Какое описание вы хотели бы присвоить");
                        String description = scanner.next();
                        manager.updateDescription(task, description);
                        System.out.println("Описание задачи успешно изменено на " + description);
                        System.out.println();
                        manager.printTask(id);
                    } else if (answer == 3) {
                        System.out.println("Задача " + task.getName() + " имеет статус " + task.getStatus());
                        manager.changeStatus(id);
                    } else {
                        System.out.println("Введена неверная команда");
                    }
                    break;
                }
                case 8: {
                    return;
                }
                default: {
                    System.out.println("Введена неверная команда");
                    System.out.println();
                    break;
                }
            }


        }

    }


    public static void printMenu() {
        System.out.println("Введите команду (1-6): ");
        System.out.println("1. Создать задачу");
        System.out.println("3. Удалить задачу по идентификатору");
        System.out.println("4. Удалить все задача");
        System.out.println("5. Найти задачу");
        System.out.println("6. Получение списка всех задач");
        System.out.println("7. Изменить имя, описание или статус задачи");
        System.out.println("8. Выход");
        System.out.println();
    }


}