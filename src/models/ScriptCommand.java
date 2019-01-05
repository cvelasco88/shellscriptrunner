package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ScriptCommand implements Serializable {

    private List<String> strings;

    public ScriptCommand() {
        this.strings = new ArrayList<>();
    }

    /* Getters & Setters */

    // Collections

    public void addString(String text) {
        this.strings.add(text);
    }

    public void clearStrings() {
        this.strings.clear();
    }

    public List<String> getStrings() {
        return strings;
    }

    /* Override */

    @Override
    public String toString() {
        return String.join(System.lineSeparator(), this.strings);
    }
}
