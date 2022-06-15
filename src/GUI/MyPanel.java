package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class MyPanel extends JPanel {

    private JComboBox jcomp2;
    private JComboBox jcomp3;
    private JLabel jcomp5;
    private JLabel jcomp6;
    int y;
    int x;

    public MyPanel(String fileName) throws IOException {
        backgroundImage = ImageIO.read(new File(fileName));
        this.y = 450;
        this.x = 900;
        Font font = new Font("Comic Sans MS",Font.PLAIN,32);
        setLayout(new BorderLayout(0,0));
        //construct preComponents
        String[] jcomp2Items = {"Humans", "Undead", "Elves","Orcs"};
        String[] jcomp3Items = {"Humans", "Undead", "Elves","Orcs"};

        //construct components
        jcomp2 = new JComboBox(jcomp2Items);
        jcomp3 = new JComboBox(jcomp3Items);
        jcomp5 = new JLabel("Fraction 1");
        jcomp6 = new JLabel("Fraction 2");
        //adjust size and set layout
        setPreferredSize(this.getMaximumSize());
        setLayout(null);

        //add components
        add(jcomp2);
        add(jcomp3);
        add(jcomp5);
        add(jcomp6);


        jcomp2.setFont(font);
        jcomp3.setFont(font);
        jcomp5.setFont(font);
        jcomp6.setFont(font);

        //set component bounds (only needed by Absolute Positioning)
        jcomp2.setBounds(x + 120, y + 60, 200, 50);
        jcomp3.setBounds(x - 120, y + 60, 200, 50);
        jcomp5.setBounds(x + 120, y, 200, 50);
        jcomp6.setBounds(x - 120, y, 200, 50);
    }

    private Image backgroundImage;


    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the background image.
        g.drawImage(backgroundImage, 0, 0, this);
    }
}

