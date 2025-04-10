package model;

import utils.Identity;

import java.util.HashMap;
import java.util.Map;

public class Manager {
    private Map<Integer, Task> taskMap = new HashMap<>();


    public void crateTask(String name, String description) {
        Task task = new Task(name, description);
        addTask(task);
    }

    public void crateEpic(String name, String description) {
        Epic task = new Epic(name, description);
        addTask(task);
    }

    public Task findTask(int id) {
        for (Map.Entry<Integer, Task> entry : taskMap.entrySet()) {
            if (entry.getKey() == id) {
                return entry.getValue();
            }
        }

        return null;
    }

    public void removeTaskById(int id) {
        Task foundTask = findTask(id);
        taskMap.remove(foundTask);
        System.out.println("Задача " + foundTask.name + " удалена");
        System.out.println("Идентификатор задачи: " + foundTask.id);
        System.out.println("Описание: " + foundTask.description);
        System.out.println("Статус: " + foundTask.status);
        System.out.println("Тип: " + foundTask.type);
        System.out.println();
    }

    public void removeAllTask() {
        taskMap.clear();
    }


    public Task addTask(Task task) {
        return taskMap.put(task.id, task);
    }

    public void printAllTasks() {
        for (Map.Entry<Integer, Task> entry : taskMap.entrySet()) {
            System.out.println("Задача: " + entry.getValue().name);
            System.out.println("Идентификатор: " + entry.getKey());
            System.out.println("Описание: " + entry.getValue().description);
            System.out.println("Статус: " + entry.getValue().status);
            System.out.println("Тип: " + entry.getValue().type);
            System.out.println();
        }
    }

}
