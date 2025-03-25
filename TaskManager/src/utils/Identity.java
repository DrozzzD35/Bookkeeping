package utils;


public enum Identity {
    INSTANCE;
    private int identifier = 0;

    //  todo написать логику создание и обновление id для новых тасков
    public int generateId() {
        return identifier++;
    }
}