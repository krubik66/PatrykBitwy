package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class gui {

    public class MyPanel extends JPanel {
        private JButton jcomp1;
        private JComboBox jcomp2;
        private JComboBox jcomp3;
        private JLabel jcomp4;
        private JLabel jcomp5;
        private JLabel jcomp6;

        public MyPanel() {
            //construct preComponents
            String[] jcomp2Items = {"Item 1", "Item 2", "Item 3"};
            String[] jcomp3Items = {"Item 1", "Item 2", "Item 3"};

            //construct components
            jcomp1 = new JButton ("Button 2");
            jcomp2 = new JComboBox (jcomp2Items);
            jcomp3 = new JComboBox (jcomp3Items);
            jcomp4 = new JLabel ("newLabel");
            jcomp5 = new JLabel ("newLabel");
            jcomp6 = new JLabel ("newLabel");

            //adjust size and set layout
            setPreferredSize (new Dimension (907, 601));
            setLayout (null);

            //add components
            add (jcomp1);
            add (jcomp2);
            add (jcomp3);
            add (jcomp4);
            add (jcomp5);
            add (jcomp6);

            //set component bounds (only needed by Absolute Positioning)
            jcomp1.setBounds (570, 450, 100, 20);
            jcomp2.setBounds (410, 445, 100, 25);
            jcomp3.setBounds (260, 445, 100, 25);
            jcomp4.setBounds (0, 0, 80, 25);
            jcomp5.setBounds (260, 400, 100, 25);
            jcomp6.setBounds (410, 400, 100, 25);
        }

        /*
        public static void main (String[] args) {
            JFrame frame = new JFrame ("MyPanel");
            frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add (new MyPanel());

            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setUndecorated(true);
            frame.setVisible(true);

            frame.pack();
            frame.setVisible (true);
        }
        */
    }

}
