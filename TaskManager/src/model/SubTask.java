package model;

import utils.Identity;

public class SubTask extends Task {

    public SubTask(String name, String description) {
        super(name, description);
        this.id = Identity.INSTANCE.generateId() - 1;
        this.status = Status.NEW;
        this.type = Type.SUBTASK;

    }

}
