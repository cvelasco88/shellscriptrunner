package views;

import helpers.ContextCompat;
import models.ScriptInstruction;
import models.ScriptBase;
import models.ScriptStep;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ScriptBaseStepView extends JPanel {


    private int currentStep = 0;
    private JPanel parentPanel;
    private JPanel self = this;

    // ctor
    public ScriptBaseStepView(JPanel parentPanel, ScriptBase smb) {

        this.parentPanel = parentPanel;

        setLayout(new BorderLayout());

        // Customize view
        setOpaque(true);
        // setBackground(new Color(0,0,0,0));
        setBackground(parentPanel.getBackground());

        // initialize
        initialize(smb);
    }

    public void initialize(ScriptBase smb){

        // clear views
        this.removeAll();
        // updateUI();

        if(currentStep < smb.getSteps().size()){

            boolean lastStep = currentStep == smb.getSteps().size() - 1;

            ScriptStep step = smb.getSteps().get(currentStep);

            // TOP
            JPanel headerPanel = new JPanel();
            headerPanel.setOpaque(true);
            headerPanel.setBackground(new Color(0,0,0,0));
            headerPanel.setLayout(new BorderLayout());

            if (!StringUtils.isEmpty(step.getTitle())){
                JLabel labelTitle = new JLabel(step.getTitle());
                ContextCompat.decorateComponent(labelTitle);
                headerPanel.add(labelTitle, BorderLayout.NORTH);
            }

            if (!StringUtils.isEmpty(step.getDescription())){
                JLabel labelDescription = new JLabel(step.getDescription());
                ContextCompat.decorateComponent(labelDescription);
                headerPanel.add(labelDescription, BorderLayout.SOUTH);
            }
            add(headerPanel, BorderLayout.NORTH);

            // LIST
            DefaultListModel<ScriptInstruction> listModel = new DefaultListModel<>();
            listModel.addAll(step.getInstructions());

            JList<ScriptInstruction> instructionList = new JList<>(listModel);
            instructionList.setCellRenderer(new ScriptInstructionViewRenderer());
            instructionList.setOpaque(true);
            ContextCompat.decorateComponent(instructionList);
            // instructionList.setBackground(new Color(0,0,0,0));


            // JScrollPane scrollPane = new JScrollPane(myList);

            // Or in two steps:
            JScrollPane scrollPane = new JScrollPane();
            scrollPane.getViewport().setView(instructionList);

            add(scrollPane, BorderLayout.CENTER);

            // BOTTOM
            JPanel bottomPanel = new JPanel();
            bottomPanel.setOpaque(true);
            bottomPanel.setBackground(new Color(0,0,0,0));
            bottomPanel.setLayout(new BorderLayout());

            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new BorderLayout());

            if(currentStep > 0){
                JButton btnNext = new JButton();
                btnNext.setText("Prev");
                btnNext.addActionListener(new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        currentStep--;
                        initialize(smb);
                    }
                });
                buttonPanel.add(btnNext, BorderLayout.WEST);
            }

            //if(!lastStep) {
                JButton btnNext = new JButton();
                btnNext.setText("Next");
                btnNext.addActionListener(new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        currentStep++;
                        initialize(smb);
                    }
                });
                btnNext.setEnabled(!lastStep); // disable
                buttonPanel.add(btnNext, BorderLayout.EAST);
            //}

            // Button
            bottomPanel.add(buttonPanel, BorderLayout.EAST);
            add(bottomPanel, BorderLayout.SOUTH);
        }

        // refresh UI
        updateUI();
    }
}
