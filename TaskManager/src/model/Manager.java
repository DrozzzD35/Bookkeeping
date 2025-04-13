package model;

import java.util.HashMap;
import java.util.Map;

public class Manager {
    private Map<Integer, Task> taskMap = new HashMap<>();
    ChangeStatus changeStatus = new ChangeStatus();


    public void crateTask(String name, String description) {
        Task task = new Task(name, description);
        addTask(task);
    }

    public void crateEpic(String name, String description) {
        Epic task = new Epic(name, description);
        addTask(task);
    }

    public void crateSubTask(String name, String description) {
        SubTask task = new SubTask(name, description);
        addTask(task);
    }

    public Task findTask(int id) {
        for (Map.Entry<Integer, Task> entry : taskMap.entrySet()) {
            if (entry.getKey() == id) {
                return entry.getValue();
            } else {
                System.out.println("Задача не найдена. Возможно неверно указан идентификатор");
                System.out.println();
            }
        }
        return null;
    }

    public void removeTaskById(int id) {
        taskMap.remove(id);
        System.out.println("Задача удалена");
        printTask(id);
        System.out.println();

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
        } else {
            for (Map.Entry<Integer, Task> entry : taskMap.entrySet()) {
                printTask(entry.getKey());
            }
        }
    }

    public void printTask(int id) {
        Task task = findTask(id);
        System.out.println("Задача: " + task.getName());
        System.out.println("Идентификатор: " + task.getId());
        System.out.println("Описание: " + task.getDescription());
        System.out.println("Статус: " + task.getStatus());
        System.out.println("Тип: " + task.getType());
        System.out.println();
    }

    public void changeStatus(int id) {
        Task task = findTask(id);
        changeStatus.changeStatus(task);
    }


    public void updateName(Task task, String name) {
        task.name = name;
    }

    public void updateDescription(Task task, String description) {
        task.description = description;
    }

    public void updateTask(Task task) {
        taskMap.put(task.id, task);
    }

    public void printAllSubTaskByEpic(Epic task) {
    }
}



