package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyPanel2 extends JPanel implements ActionListener {
    private JPanel panel1;
    private JButton jButton;
    private JPanel panel2;

    boolean isFirstOn;

    public MyPanel2(JPanel panel1, JPanel panel2) {
        //construct components
        this.panel1 = panel1;
        this.panel2 = panel2;
        isFirstOn = true;
        setLayout(null);

        jButton = new JButton("Start");
        jButton.addActionListener(this);
        add(jButton);
        add(this.panel1);
        jButton.setFont(new Font("Comic Sans MS",Font.PLAIN,32));
        this.panel1.setBounds(0,0,2000,1000);
        this.panel2.setBounds(0,0,2000,1000);
        jButton.setBounds(900,0,200,40);
        this.revalidate();
        this.repaint();



        //adjust size and set layout
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (isFirstOn) {
            remove(panel1);
            add(panel2);
            jButton.setBounds(900,0,200,40);
        } else {
            remove(panel2);
            add(panel1);
            jButton.setBounds(900,0,200,40);
        }
        isFirstOn ^= true;
        this.revalidate();
        this.repaint();

    }
}
