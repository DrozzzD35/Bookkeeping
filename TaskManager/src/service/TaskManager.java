package service;

import model.Epic;
import model.SubTask;
import model.Task;

import java.util.List;
import java.util.Map;

public interface TaskManager<T extends Task> {

    void add(T task);

    List<T> getTasks();

    T getTaskById(int id);

    void updateTask(T task);

    void removeTaskById(int id);

    void removeAllTasks();

    List<SubTask> getAllSubtasksByEpicId(int epicId);
}
