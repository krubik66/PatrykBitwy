package GUI;

import settings.CurrentGameData;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ChoosingFractionsPanel extends JPanel {

    private JComboBox firstComboBox;
    private JComboBox secondComboBox;
    private JLabel firstFractionLabel;
    private JLabel secondFractionLabel;
    int y;
    int x;

    public ChoosingFractionsPanel(String fileName) throws IOException {
        backgroundImage = ImageIO.read(new File(fileName));
        this.y = 450;
        this.x = 900;
        Font font = new Font("Comic Sans MS",Font.PLAIN,32);
        setLayout(new BorderLayout(0,0));
        //construct preComponents
        String[] avaliableRaces = {"Humans", "Undead", "Elves","Orcs"};

        //construct components
        firstComboBox = new JComboBox(avaliableRaces);
        secondComboBox = new JComboBox(avaliableRaces);
        firstFractionLabel = new JLabel("Fraction 1");
        secondFractionLabel = new JLabel("Fraction 2");
        //adjust size and set layout
        setPreferredSize(this.getMaximumSize());
        setLayout(null);

        //add components
        add(firstComboBox);
        add(secondComboBox);
        add(firstFractionLabel);
        add(secondFractionLabel);


        firstComboBox.setFont(font);
        secondComboBox.setFont(font);
        firstFractionLabel.setFont(font);
        secondFractionLabel.setFont(font);

        //set component bounds (only needed by Absolute Positioning)
        firstComboBox.setBounds(x + 120, y + 60, 200, 50);
        secondComboBox.setBounds(x - 120, y + 60, 200, 50);
        firstFractionLabel.setBounds(x + 120, y, 200, 50);
        secondFractionLabel.setBounds(x - 120, y, 200, 50);
    }

    private Image backgroundImage;


    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the background image.
        g.drawImage(backgroundImage, 0, 0, this);
    }

    public void saveComboBoxes() {
        CurrentGameData.attackingFractionNumber = firstComboBox.getSelectedIndex();
        CurrentGameData.defendingFractionNumber = secondComboBox.getSelectedIndex();
    }
}

