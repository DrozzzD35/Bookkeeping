package model;

import java.util.HashMap;
import java.util.Map;

public class Manager {
    private Map<Integer, Task> taskMap = new HashMap<>();


    public void crateTask(String name, String description) {
        Task task = new Task(name, description);
        addTask(task);
    }

    public void crateEpic(String name, String description) {
        Task task = new Epic(name, description);
        addTask(task);
    }

    public void crateSubTask(String name, String description, int idEpic) {
        if (!(findTask(idEpic) == null)) {
            Task task = new SubTask(name, description, idEpic);
            addTask(task);
        } else {
            System.out.println("Большая задача не найдена");
        }
    }

    public Task findTask(int id) {
        if (!taskMap.isEmpty()) {
            for (Map.Entry<Integer, Task> entry : taskMap.entrySet()) {
                if (entry.getKey() == id) {
                    return entry.getValue();
                } else {
                    System.out.println("Задача не найдена. Возможно неверно указан идентификатор");
                    System.out.println();
                    break;
                }
            }
        } else {
            System.out.println("В настоящий момент задач нет");
            System.out.println();
        }
        return null;
    }

    public void removeTaskById(int id) {
        printTask(id);
        Task task = findTask(id);
        if (!(task == null)) {
            taskMap.remove(id);
            System.out.println("Задача удалена");
            System.out.println();
        }

    }

    public void removeAllTask() {
        taskMap.clear();
    }


    public Task addTask(Task task) {
        return taskMap.put(task.id, task);
    }

    public void printAllTasks() {
        if (taskMap.isEmpty()) {
            System.out.println("В настоящий момент задач нет");
            System.out.println();
        } else {
            for (Map.Entry<Integer, Task> entry : taskMap.entrySet()) {
                System.out.println("Задача: " + entry.getValue().getName());
                System.out.println("Идентификатор: " + entry.getValue().getId());
                System.out.println("Описание: " + entry.getValue().getDescription());
                System.out.println("Статус: " + entry.getValue().getStatus());
                System.out.println("Тип: " + entry.getValue().getType());
                System.out.println();
            }
        }
    }

    public void printTask(int id) {
        Task task = findTask(id);
        if (!(task == null)) {
            System.out.println("Задача: " + task.getName());
            System.out.println("Идентификатор: " + task.getId());
            System.out.println("Описание: " + task.getDescription());
            System.out.println("Статус: " + task.getStatus());
            System.out.println("Тип: " + task.getType());
            System.out.println();
        }
    }

    public void changeStatus(int id) {
        ChangeStatus changeStatus = new ChangeStatus();
        Task task = findTask(id);
        changeStatus.changeStatus(task);
    }


    public void updateName(Task task, String name) {
        task.name = name;
    }

    public void updateDescription(Task task, String description) {
        task.description = description;
    }

    public void updateTask(int oldTask, Task newTask) {
        Task deletTask = findTask(oldTask);
        int id = deletTask.getId();
        taskMap.remove(id);
        taskMap.put(id, newTask);
    }

    public void printAllEpic() {
        for (Map.Entry<Integer, Task> entry : taskMap.entrySet()) {
            if (entry.getValue().type == Type.EPIC) {
                System.out.println("Задача: " + entry.getValue().getName());
                System.out.println("Идентификатор: " + entry.getValue().getId());
                System.out.println("Описание: " + entry.getValue().getDescription());
                System.out.println("Статус: " + entry.getValue().getStatus());
                System.out.println("Тип: " + entry.getValue().getType());
                System.out.println();
            }
        }
    }

    public void printAllSubTaskByEpic(int idEpic) {
        if (!(findTask(idEpic) == null)) {
            for (Map.Entry<Integer, Task> entry : taskMap.entrySet()) {
                if (entry.getValue().type == Type.SUBTASK) {

                }

            }
        }
    }
}



