package model;

import utils.Identity;

import java.util.HashMap;
import java.util.Map;

public class Epic extends Task {


    public Epic(String name, String description) {
        super(name, description);
        this.id = Identity.INSTANCE.generateId() - 1;
        this.type = Type.EPIC;
        this.status = Status.NEW;
    }
}
