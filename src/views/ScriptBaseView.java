package views;

import models.MyCellRenderer;
import models.ScriptBase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ScriptBaseView extends JPanel {


    private JPanel rootPanel;
    private JPanel self = this;

    // ctor
    public ScriptBaseView(JPanel rootPanel, ScriptBase smb) {

        this.rootPanel = rootPanel;

        setLayout(new BorderLayout());

        // Customize view
        setBackground(Color.RED);

        //this.container = container;
        initialize(smb);
    }

    public void initialize(ScriptBase smb){

        // clear views
        this.removeAll();
        // updateUI();

        JLabel label1 = new JLabel("MyLabel 1");

        //Add the ubiquitous "Hello World" label.
        JLabel label2 = new JLabel("Hello World");




        JButton btnMessage = new JButton();
        btnMessage.setText("Show message");
        btnMessage.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                JOptionPane.showMessageDialog(self, "Hello World! :)" );
            }
        });

        ///

        // Create a JList that displays strings from an array

        String[] data = {"one", "two", "three", "four"};
        JList myList = new JList(data);

        myList.setCellRenderer(new MyCellRenderer());

        // JScrollPane scrollPane = new JScrollPane(myList);

        // Or in two steps:
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.getViewport().setView(myList);

        add(label1, BorderLayout.NORTH);
        add(label2, BorderLayout.SOUTH);
        add(btnMessage, BorderLayout.WEST);
        add(scrollPane, BorderLayout.CENTER);

    }

}
