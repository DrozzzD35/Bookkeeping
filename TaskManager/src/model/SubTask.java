package model;

import utils.Identity;

public class SubTask extends Task {
    private int idEpic;

    public SubTask(String name, String description, int idEpic) {
        super(name, description);
        this.id = Identity.INSTANCE.generateId();
        this.status = Status.NEW;
        this.type = Type.SUBTASK;
        this.idEpic = idEpic;

    }

    public int getIdEpic() {
        return idEpic;
    }

}
