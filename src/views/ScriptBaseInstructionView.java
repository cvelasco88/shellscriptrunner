package views;

import helpers.ContextCompat;
import models.ScriptCommand;
import models.ScriptInstruction;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ScriptBaseInstructionView extends JPanel {


    // Create Swing components
    private JLabel labelTitle;
    private JLabel labelDescription;
    private JPanel panelCommands;

    // ctor
    public ScriptBaseInstructionView() {

        setLayout(new BorderLayout());
        setOpaque(true);
        setBackground(new Color(0, 0, 0, 0));
        //setBackground(parentView.getBackground());

        labelTitle = new JLabel();
        ContextCompat.decorateComponent(labelTitle);

        labelDescription = new JLabel();
        ContextCompat.decorateComponent(labelDescription);

        panelCommands = new JPanel();
        panelCommands.setOpaque(true);
        panelCommands.setBackground(new Color(0,0,0,0));
        panelCommands.setLayout(new BoxLayout(panelCommands, BoxLayout.PAGE_AXIS));

        add(labelTitle, BorderLayout.NORTH);
        add(labelDescription, BorderLayout.CENTER);
        add(panelCommands, BorderLayout.SOUTH);
    }

    public ScriptBaseInstructionView(ScriptInstruction instruction) {

        this();

        // Create Swing components
        setLabelTitle(instruction.getTitle());

        setLabelDescription(instruction.getDescription());

        // commands
        setPanelCommands(instruction.getCommands());

        // Add behaviour
    }


    public void setLabelTitle(String labelTitle) {
        this.labelTitle.setText(labelTitle);
        this.labelTitle.setVisible(!StringUtils.isEmpty(labelTitle));
    }


    public void setLabelDescription(String labelDescription) {
        this.labelDescription.setText(labelDescription);
        this.labelDescription.setVisible(!StringUtils.isEmpty(labelDescription));
    }

    public void setPanelCommands(List<ScriptCommand> commands) {
        this.panelCommands.removeAll();
        // commands
        for(ScriptCommand command : commands) {
            String commandValue = command.toString();
            if (!StringUtils.isEmpty(commandValue)) {
                JPanel labelPanel = new JPanel();
                labelPanel.setOpaque(true);
                labelPanel.setBackground(new Color(0,0,0,0));
                labelPanel.setLayout(new BorderLayout());

                JTextArea label = new JTextArea(commandValue);
                label.setLineWrap(true);
                label.setOpaque(true);
                label.setBackground(Color.BLACK);
                label.setForeground(Color.WHITE);
                label.setBorder(new EmptyBorder(5,5,5,5));//top,left,bottom,right

                // labelPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                // labelPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));

                labelPanel.setBorder(new EmptyBorder(5,5,5,5));//top,left,bottom,right
                labelPanel.add(label, BorderLayout.WEST);

                // Add Swing components to content panel
                this.panelCommands.add(labelPanel);
            }
        }
    }

}