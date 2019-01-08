package helpers;

import javax.swing.*;
import java.awt.*;

public class ContextCompat {

    private static boolean active;
    private static ContextTheme theme;

    private static ContextCompat mContextCompat;

    public static ContextCompat getInstance() {

        if (mContextCompat == null) {

            mContextCompat = new ContextCompat();
        }
        return mContextCompat;
    }

    private ContextCompat() {
        this.active = true;

        this.theme = new ContextTheme();
        this.theme.setColorText(Color.decode(ContextColors.COLOR_TEXT));
        this.theme.setColorPanel(Color.decode(ContextColors.COLOR_WHITE));
        this.theme.setColorList(Color.decode(ContextColors.COLOR_LIGHTGRAY));
    }

    public static void decorateComponent(Component component){

        ContextCompat contextCompat = ContextCompat.getInstance();

        if(contextCompat.isActive()){
            Class<? extends Component> clazz = component.getClass();

            if(clazz.isAssignableFrom(JLabel.class)){
                component.setForeground(contextCompat.getTheme().getColorText());

            } else if(clazz.isAssignableFrom(JPanel.class)){
                component.setBackground(contextCompat.getTheme().getColorPanel());

            } else if(clazz.isAssignableFrom(JButton.class)){
                component.setBackground(contextCompat.getTheme().getColorButton());

            } else if(clazz.isAssignableFrom(JList.class)){
                component.setBackground(contextCompat.getTheme().getColorList());

            }
        }

    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public ContextTheme getTheme() {
        return theme;
    }

    public void setTheme(ContextTheme theme) {
        this.theme = theme;
    }
}
