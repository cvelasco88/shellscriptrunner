import javax.swing.*;

public class Main {

        /**
         * Create the GUI and show it.  For thread safety,
         * this method should be invoked from the
         * event-dispatching thread.
         */
        private static void createAndShowGUI() {
                SwingUtilities.invokeLater(() -> {

                        try {
                                // Set cross-platform Java L&F (also called "Metal")
                                UIManager.setLookAndFeel(
                                        UIManager.getCrossPlatformLookAndFeelClassName());
                        }
                        catch (UnsupportedLookAndFeelException e) {
                                // handle exception
                        }
                        catch (ClassNotFoundException e) {
                                // handle exception
                        }
                        catch (InstantiationException e) {
                                // handle exception
                        }
                        catch (IllegalAccessException e) {
                                // handle exception
                        }

                        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                                if ("com.sun.java.swing.plaf.gtk.GTKLookAndFeel".equals(info.getClassName())) {
                                        try {
                                                UIManager.setLookAndFeel(info.getClassName());

                                        } catch (ClassNotFoundException e) {
                                                e.printStackTrace();
                                        } catch (InstantiationException e) {
                                                e.printStackTrace();
                                        } catch (IllegalAccessException e) {
                                                e.printStackTrace();
                                        } catch (UnsupportedLookAndFeelException e) {
                                                e.printStackTrace();
                                        }
                                        break;
                                }
                        }

                        MainForm form = new MainForm();
                        //Display the window.
                        form.pack();
                        form.setVisible(true);
                });
        }

        public static void main(String[] args){
                //Schedule a job for the event-dispatching thread:
                //creating and showing this application's GUI.
                javax.swing.SwingUtilities.invokeLater(new Runnable(){
                        public void run(){
                                createAndShowGUI();
                        }
                });
        }
}
