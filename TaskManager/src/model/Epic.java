package model;

import utils.Identity;

public class Epic extends Task {


    public Epic(String nameEpic, String descriptionEpic) {
        super(nameEpic, descriptionEpic);
        this.id = Identity.INSTANCE.generateId() - 1;
        this.type = Type.EPIC;
        this.status = Status.NEW;
    }
}