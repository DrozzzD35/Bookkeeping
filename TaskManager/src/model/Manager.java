package model;

import java.util.HashMap;
import java.util.Map;

public class Manager {
    private Map<Integer, Task> taskMap = new HashMap<>();


    public Task findTask(int id) {
        for (Map.Entry<Integer, Task> entry : taskMap.entrySet()) {
            if (entry.getKey() == id) {
                return (Task) entry;
            }
        }

        return null;
    }

    public void removeTaskById(int id) {
        Task foundTask = findTask(id);
        taskMap.remove(foundTask);
        System.out.println("Задача " + foundTask.name + " удалена");
    }

    public void removeAllTask() {
        taskMap.clear();
    }


    public Task addTask(int id, Task task) {
        return taskMap.put(id, task);
    }

    public void printAllTasks() {
        for (Map.Entry<Integer, Task> entry : taskMap.entrySet()) {
            System.out.println("Идентификатор задачи: " + entry.getKey());
            System.out.println("Задача: " + entry.getValue());
            System.out.println();
        }
    }

}
