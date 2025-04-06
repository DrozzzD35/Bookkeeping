package model;

import utils.Identity;

import java.util.HashMap;
import java.util.Map;

public class SubTask extends Task {

    public SubTask(String name, String description) {
        super(name, description);
        this.id = Identity.INSTANCE.generateId();
        this.status = Status.NEW;
        this.type = Type.SUBTASK;

    }

}
