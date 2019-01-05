import models.ScriptBase;
import models.ScriptCommand;
import models.ScriptInstruction;
import models.ScriptStep;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainForm extends JFrame {
    private JButton btnMessage;
    private JPanel rootPanel;

    public MainForm() {

        add(rootPanel);

        //Add the ubiquitous "Hello World" label.
        JLabel label = new JLabel("Hello World");
        getContentPane().add(label);

        btnMessage.setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(500, 500));

        btnMessage.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                JOptionPane.showMessageDialog(rootPanel, "Hello World! :)" );
            }
        });

        ScriptBase smb = createScriptModelBase();
    }

    private ScriptBase createScriptModelBase() {
        ScriptBase smb = createScriptModelBase();

        // initialize
        smb.setTitle("My Shell Script Runner");
        smb.setDescription("Made with love. Version 1.0.0");

        // Step 1
        ScriptStep step1 = new ScriptStep();
        step1.setTitle("Prepare Script");
        step1.setDescription("Prepare Script content");

        for(int i=0;i<10;i++) {
            ScriptInstruction instruction = new ScriptInstruction();
            ScriptCommand command1 = new ScriptCommand();
            command1.addString("ls");
            command1.addString("cd");
            instruction.addCommand(command1);

            ScriptCommand command2 = new ScriptCommand();
            command2.addString("pwd");
            instruction.addCommand(command2);
            // add instruction commands
            step1.addInstruction(instruction);
        }

        // Step 2
        ScriptStep step2 = new ScriptStep();
        step2.setTitle("Running Script");
        step2.setDescription("Running Script content");

        for(int i=0;i<3;i++) {
            ScriptInstruction instruction = new ScriptInstruction();
            ScriptCommand command1 = new ScriptCommand();
            command1.addString("ls");
            command1.addString("cd");
            instruction.addCommand(command1);

            ScriptCommand command2 = new ScriptCommand();
            command2.addString("pwd");
            instruction.addCommand(command2);
            step2.addInstruction(instruction);
        }

        // Step 3
        ScriptStep step3 = new ScriptStep();
        // step3.setTitle("Empty Script");
        // step3.setDescription("Empty Script content");

        // Step 4
        ScriptStep step4 = new ScriptStep();
        step4.setTitle("Final Script");
        step4.setDescription("Final Script content");

        for(int i=0;i<10;i++) {
            ScriptInstruction instruction = new ScriptInstruction();
            ScriptCommand command1 = new ScriptCommand();
            command1.addString("ls");
            command1.addString("cd");
            instruction.addCommand(command1);

            ScriptCommand command2 = new ScriptCommand();
            command2.addString("pwd");
            instruction.addCommand(command2);
            step4.addInstruction(instruction);
        }

        // Add Steps
        smb.addSteps(step1);
        smb.addSteps(step2);
        smb.addSteps(step3);
        smb.addSteps(step4);

        // return
        return smb;
    }
}
