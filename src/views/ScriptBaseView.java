package views;

import helpers.ContextColors;
import helpers.ContextCompat;
import models.MyCellRenderer;
import models.ScriptBase;
import models.ScriptStep;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ScriptBaseView extends JPanel {



    // ctor
    public ScriptBaseView(Component parentView, ScriptBase smb) {

        setLayout(new BorderLayout());

        // Customize view
        setOpaque(true);
        // setBackground(new Color(0,0,0,0));
        setBackground(parentView.getBackground());

        // Create Swing components
        JPanel topPanel = new JPanel();
        JPanel middlePanel = new JPanel();
        JPanel bottomPanel = new JPanel();

        topPanel.setLayout(new BorderLayout());
        middlePanel.setLayout(new BorderLayout());
        bottomPanel.setLayout(new BorderLayout());

        // Add Swing components to content panel

        add(topPanel, BorderLayout.NORTH);
        add(middlePanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // Customize views
        topPanel.setBackground(Color.decode(ContextColors.COLOR_APP));
        ContextCompat.decorateComponent(middlePanel);
        bottomPanel.setBackground(Color.decode(ContextColors.COLOR_APP));

        // Add extra views
        initializeTopPanel(topPanel, smb);
        initializeMiddlePanel(middlePanel, smb);
        initializeBottomPanel(bottomPanel, smb);

        // Add behaviour
    }

    private void initializeTopPanel(JPanel topPanel, ScriptBase smb) {

        /* HEADER */
        JPanel headerPanel = new JPanel();
        headerPanel.setOpaque(true);
        headerPanel.setBackground(new Color(0,0,0,0));
        headerPanel.setLayout(new BorderLayout());


        if (!StringUtils.isEmpty(smb.getTitle())){
            JLabel labelTitle = new JLabel(smb.getTitle());
            headerPanel.add(labelTitle, BorderLayout.NORTH);
        }


        if (!StringUtils.isEmpty(smb.getDescription())){	        // Add View
            JLabel labelDescription = new JLabel(smb.getDescription());
            headerPanel.add(labelDescription, BorderLayout.SOUTH);
        }
        topPanel.add(headerPanel, BorderLayout.WEST);

        /* CONTENT */
        topPanel.add(new JLabel(), BorderLayout.CENTER);

        /* BUTTONS */
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setOpaque(true);
        buttonsPanel.setBackground(new Color(0,0,0,0));
        buttonsPanel.setLayout(new BorderLayout());

        // Select File
        JButton btnSelect = new JButton();
        btnSelect.setText("Select File");
        btnSelect.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                // TODO: falta implementar
            }
        });
        buttonsPanel.add(btnSelect, BorderLayout.WEST);

        // Run
        JButton btnMessage = new JButton();
        btnMessage.setText("Run");
        btnMessage.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                JOptionPane.showMessageDialog(buttonsPanel, "Hello World! :)" );
            }
        });
        buttonsPanel.add(btnMessage, BorderLayout.EAST);

        // Add View
        topPanel.add(buttonsPanel, BorderLayout.EAST);
    }

    private void initializeMiddlePanel(JPanel middlePanel, ScriptBase smb) {
        ScriptBaseListView sbv = new ScriptBaseListView(middlePanel, smb);

        // Add View
        middlePanel.add(sbv, BorderLayout.CENTER);
    }

    private void initializeBottomPanel(JPanel bottomPanel, ScriptBase smb) {
        // Bottom
        JLabel labelBottom = new JLabel();
        labelBottom.setText("Steps number: " + smb.getSteps().size());

        // Add View
        bottomPanel.add(labelBottom);
    }
}
