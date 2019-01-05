package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ScriptInstruction implements Serializable {

    private String title;
    private String description;
    private boolean checked;
    private boolean done;

    private List<ScriptCommand> commands;

    public ScriptInstruction() {
        this.title = null;
        this.description = null;
        this.checked = false;
        this.done = false;
        this.commands = new ArrayList<>();
    }

    /* Getters & Setters */

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    // Collections

    public void addCommand(ScriptCommand command) {
        this.commands.add(command);
    }

    public void clearCommands() {
        this.commands.clear();
    }

    public List<ScriptCommand> getCommands() {
        return commands;
    }

}
