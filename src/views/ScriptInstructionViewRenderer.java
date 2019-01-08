package views;

import models.ScriptCommand;
import models.ScriptInstruction;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Display an icon and a string for each object in the list.
 */
public class ScriptInstructionViewRenderer extends ScriptBaseInstructionView implements ListCellRenderer<ScriptInstruction> {


    public ScriptInstructionViewRenderer() {
        super();
    }

    // This is the only method defined by ListCellRenderer.
    // We just reconfigure the JLabel each time we're called.

    public Component getListCellRendererComponent(
            JList<? extends ScriptInstruction> list,              // the list
            ScriptInstruction value,            // value to display
            int index,               // cell index
            boolean isSelected,      // is the cell selected
            boolean cellHasFocus)    // does the cell have focus
    {
        //pnl.removeAll();

        setLabelTitle(value.getTitle());
        setLabelDescription(value.getDescription());
        setPanelCommands(value.getCommands());

        // customize views
        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
        setEnabled(list.isEnabled());
        setFont(list.getFont());
        setOpaque(true);

        return this;

    }

    private Component getView(ScriptInstruction value, int index) {

        JPanel panel = new JPanel();
        panel.setOpaque(true);
        panel.setBackground(new Color(0,0,0,0));
        panel.setBackground(Color.GREEN);
        panel.setLayout(new BorderLayout());
        panel.setSize(this.getWidth(), 80);
        panel.updateUI();

        JLabel labelInd = new JLabel("index: " + index);
        labelInd.setForeground(Color.CYAN);
        panel.add(labelInd, BorderLayout.NORTH);
        if(!StringUtils.isEmpty(value.getTitle())) {
            JLabel label = new JLabel(value.getTitle());
            panel.add(label);
        }
        if(!StringUtils.isEmpty(value.getDescription())) {
            JLabel label = new JLabel(value.getDescription());
            panel.add(label);
        }
        // commands
        for(ScriptCommand command : value.getCommands()) {
            String commandValue = command.toString();
            if (!StringUtils.isEmpty(commandValue)) {
                JLabel label = new JLabel(commandValue);
                label.setBackground(Color.BLACK);
                label.setForeground(Color.WHITE);
                panel.add(label);
            }
        }

        // return view
        return panel;
    }
}