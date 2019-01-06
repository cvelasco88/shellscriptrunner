package models;

import javax.swing.*;
import java.awt.*;

/**
 * Display an icon and a string for each object in the list.
 */
public class MyCellRenderer extends JLabel implements ListCellRenderer {


        final static ImageIcon longIcon = new ImageIcon("icon.png");
        final static ImageIcon shortIcon = new ImageIcon("icon.png");

        // This is the only method defined by ListCellRenderer.
        // We just reconfigure the JLabel each time we're called.

        public Component getListCellRendererComponent(
                JList list,              // the list
                Object value,            // value to display
                int index,               // cell index
                boolean isSelected,      // is the cell selected
                boolean cellHasFocus)    // does the cell have focus
        {
            String s = value.toString();
            setText(s);
            setIcon((s.length() > 10) ? longIcon : shortIcon);
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
    }