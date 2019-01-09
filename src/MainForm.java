import models.ScriptBase;
import models.ScriptCommand;
import models.ScriptInstruction;
import models.ScriptStep;
import terminal.JTerminal;
import views.ScriptBaseView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

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
        //topPanel.setBackground(Color.decode(ContextColors.COLOR_APP));
        //ContextCompat.decorateComponent(middlePanel);
        //bottomPanel.setBackground(Color.decode(ContextColors.COLOR_APP));

        // Add extra views
        initializeTopPanel(topPanel, smb);
        initializeMiddlePanel(middlePanel, smb);
        initializeBottomPanel(bottomPanel, smb);

        // Add behaviour
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(500, 500));
    }

    private void initializeTopPanel(JPanel topPanel, ScriptBase smb) {

        JMenuBar menuBar = getMainMenuBar();

        /* HEADER */
        JPanel headerPanel = new JPanel();
        headerPanel.setOpaque(true);
        headerPanel.setBackground(new Color(0,0,0,0));
        headerPanel.setLayout(new BorderLayout());

        // Add View
        this.setJMenuBar(menuBar);
        topPanel.add(headerPanel, BorderLayout.SOUTH);
    }

    private void initializeMiddlePanel(JPanel middlePanel, ScriptBase smb) {
        ScriptBaseView sbv = new ScriptBaseView(middlePanel, smb);

        // Add View
        middlePanel.add(sbv, BorderLayout.CENTER);
    }

    private void initializeBottomPanel(JPanel bottomPanel, ScriptBase smb) {
        // TextArea
        /*JPanel promtPanel = new JPanel();
        promtPanel.setOpaque(true);
        promtPanel.setBackground(new Color(0,0,0,0));
        promtPanel.setBackground(Color.RED);
        promtPanel.setLayout(new BorderLayout());

        JTerminal terminal = new JTerminal();


        ///

        JTextArea chatArea = new JTextArea(8, 40);
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

        mainPanel.add(chatPanel);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(youLabelPanel);
        mainPanel.add(inputPanel);
        //middlePanel.add(sbv);

        promtPanel.add(Box.createVerticalStrut(10));
        promtPanel.add(youLabelPanel);
        promtPanel.add(inputPanel);


        // Add View
        bottomPanel.add(promtPanel);*/
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
            instruction.setTitle("Basic commands");
            instruction.setDescription("Basic commands below");
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

    private JToolBar getToolBar() {
        JToolBar barraBotones = new JToolBar();
        barraBotones.add(new JButton("File"));
        barraBotones.add(new JButton("2"));
        barraBotones.add(new JButton("3"));
        barraBotones.add(new JButton("4"));
        barraBotones.add(new JButton("5"));
        return barraBotones;
    }

    private JMenuBar getMainMenuBar(){

        //Where the GUI is created:
        JMenuBar menuBar;
        JMenu menu, submenu;
        JMenuItem menuItem;
        JRadioButtonMenuItem rbMenuItem;
        JCheckBoxMenuItem cbMenuItem;

        //Create the menu bar.
        menuBar = new JMenuBar();

        //Build the first menu.
        menu = new JMenu("A Menu");
        menu.setMnemonic(KeyEvent.VK_A);
        menu.getAccessibleContext().setAccessibleDescription(
                "The only menu in this program that has menu items");
        menuBar.add(menu);

        //a group of JMenuItems
        menuItem = new JMenuItem("A text-only menu item",
                KeyEvent.VK_T);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_1, ActionEvent.ALT_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription(
                "This doesn't really do anything");
        menu.add(menuItem);

        menuItem = new JMenuItem("Both text and icon",
                new ImageIcon("images/middle.gif"));
        menuItem.setMnemonic(KeyEvent.VK_B);
        menu.add(menuItem);

        menuItem = new JMenuItem(new ImageIcon("images/middle.gif"));
        menuItem.setMnemonic(KeyEvent.VK_D);
        menu.add(menuItem);

        //a group of radio button menu items
        menu.addSeparator();
        ButtonGroup group = new ButtonGroup();
        rbMenuItem = new JRadioButtonMenuItem("A radio button menu item");
        rbMenuItem.setSelected(true);
        rbMenuItem.setMnemonic(KeyEvent.VK_R);
        group.add(rbMenuItem);
        menu.add(rbMenuItem);

        rbMenuItem = new JRadioButtonMenuItem("Another one");
        rbMenuItem.setMnemonic(KeyEvent.VK_O);
        group.add(rbMenuItem);
        menu.add(rbMenuItem);

        //a group of check box menu items
        menu.addSeparator();
        cbMenuItem = new JCheckBoxMenuItem("A check box menu item");
        cbMenuItem.setMnemonic(KeyEvent.VK_C);
        menu.add(cbMenuItem);

        cbMenuItem = new JCheckBoxMenuItem("Another one");
        cbMenuItem.setMnemonic(KeyEvent.VK_H);
        menu.add(cbMenuItem);

        //a submenu
        menu.addSeparator();
        submenu = new JMenu("A submenu");
        submenu.setMnemonic(KeyEvent.VK_S);

        menuItem = new JMenuItem("An item in the submenu");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_2, ActionEvent.ALT_MASK));
        submenu.add(menuItem);

        menuItem = new JMenuItem("Another item");
        submenu.add(menuItem);
        menu.add(submenu);

        //Build second menu in the menu bar.
        menu = new JMenu("Another Menu");
        menu.setMnemonic(KeyEvent.VK_N);
        menu.getAccessibleContext().setAccessibleDescription(
                "This menu does nothing");
        menuBar.add(menu);

        return menuBar;
    }
}
