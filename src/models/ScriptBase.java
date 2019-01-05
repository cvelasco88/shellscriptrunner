package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ScriptBase implements Serializable {

    private String title;
    private String description;
    private boolean readOnly;
    private boolean runnable;

    private List<ScriptStep> steps;

    public ScriptBase() {
        this.title = null;
        this.description = null;
        this.readOnly = false;
        this.runnable = true;
        this.steps = new ArrayList<>();
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

    public boolean isReadOnly() {
        return readOnly;
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    public boolean isRunnable() {
        return runnable;
    }

    public void setRunnable(boolean runnable) {
        this.runnable = runnable;
    }

    // Collections

    public void addSteps(ScriptStep step) {
        this.steps.add(step);
    }

    public void clearSteps() {
        this.steps.clear();
    }

    public List<ScriptStep> getSteps(){
        return this.steps;
    }

}
