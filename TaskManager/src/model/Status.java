package model;

public enum Status {
    NEW("Новая задача"),
    IN_PROGRESS("В процессе выполнения"),
    DONE("Задача завершена");

    private String status;

    Status(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return status;
    }
}
