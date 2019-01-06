import helpers.ContextColors;
import helpers.ContextCompat;
import models.*;
import org.apache.commons.lang3.StringUtils;
import views.ScriptBaseView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainForm extends JFrame {

    private JPanel rootPanel;

    public MainForm() {
        super();

        add(rootPanel);

        // Set Layout
        setLayout(new BorderLayout());

        // Create Swing components
        JPanel topPanel = new JPanel();
        JPanel middlePanel = new JPanel();
        JPanel bottomPanel = new JPanel();

        topPanel.setLayout(new BorderLayout());
        middlePanel.setLayout(new BorderLayout());
        bottomPanel.setLayout(new BorderLayout());

        ScriptBase smb = createScriptModelBase();

        // Add Swing components to content panel
        Container c = getContentPane();

        c.add(topPanel, BorderLayout.NORTH);
        c.add(middlePanel, BorderLayout.CENTER);
        c.add(bottomPanel, BorderLayout.SOUTH);

        // Customize views
        topPanel.setBackground(Color.decode(ContextColors.COLOR_APP));
        ContextCompat.decorateComponent(middlePanel);
        bottomPanel.setBackground(Color.decode(ContextColors.COLOR_APP));

        // Add extra views
        initializeTopPanel(topPanel, smb);
        initializeMiddlePanel(middlePanel, smb);
        initializeBottomPanel(bottomPanel, smb);

        // Add behaviour
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(500, 500));

        /*JTextArea chatArea = new JTextArea(8, 40);
        chatArea.setEditable(false);
        chatArea.setFocusable(false);
        JScrollPane chatScroll = new JScrollPane(chatArea);
        JPanel chatPanel = new JPanel(new BorderLayout());
        chatPanel.add(new JLabel("Chat:", SwingConstants.LEFT), BorderLayout.PAGE_START);
        chatPanel.add(chatScroll);

        JTextField inputField = new JTextField(40);
        JButton sendBtn = new JButton("Send");
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.LINE_AXIS));
        inputPanel.add(inputField);
        inputPanel.add(sendBtn);

        JPanel youLabelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        youLabelPanel.add(new JLabel("You:"));

        JPanel mainPanel = rootPanel;


        add(mainPanel);

        //rootPanel.add(mainPanel);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(500, 500));

        ScriptBase smb = createScriptModelBase();

        ScriptBaseView sbv = new ScriptBaseView(smb);

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        /*mainPanel.add(chatPanel);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(youLabelPanel);
        mainPanel.add(inputPanel);*/
        //middlePanel.add(sbv);
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

        if (!StringUtils.isEmpty(smb.getDescription())){
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

        // Add buttons
        topPanel.add(buttonsPanel, BorderLayout.EAST);
    }

    private void initializeMiddlePanel(JPanel middlePanel, ScriptBase smb) {
        ScriptBaseView sbv = new ScriptBaseView(middlePanel, smb);

        //middlePanel.add(new JLabel("AAAAA"), BorderLayout.NORTH);
        middlePanel.add(sbv, BorderLayout.CENTER);
    }

    private void initializeBottomPanel(JPanel bottomPanel, ScriptBase smb) {
        // Bottom
        JLabel labelBottom = new JLabel();
        labelBottom.setText("Steps number: " + smb.getSteps().size());
        bottomPanel.add(labelBottom);
    }

    /**
     * TODO: remove me
     * @return
     */
    private ScriptBase createScriptModelBase() {
        ScriptBase smb = new ScriptBase();

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
