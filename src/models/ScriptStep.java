package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ScriptStep implements Serializable {

    private String title;
    private String description;
    private boolean allStepsRequired;

    private List<ScriptInstruction> instructions;

    public ScriptStep() {
        this.title = null;
        this.description = null;
        this.allStepsRequired = false;
        this.instructions = new ArrayList<>();
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

    public boolean isAllStepsRequired() {
        return allStepsRequired;
    }

    public void setAllStepsRequired(boolean allStepsRequired) {
        this.allStepsRequired = allStepsRequired;
    }

    // Collections

    public void addInstruction(ScriptInstruction instruction) {
        this.instructions.add(instruction);
    }

    public void clearInstructions() {
        this.instructions.clear();
    }

    public List<ScriptInstruction> getInstructions(){
        return this.instructions;
    }
}
