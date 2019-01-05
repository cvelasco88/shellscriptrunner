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
    }
}
