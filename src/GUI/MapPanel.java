package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.IconUIResource;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MapPanel extends JPanel {

    private JLabel[][] tiles;
    private JLabel[][] units;

    public MapPanel(int size) {

        setLayout(null);

        try {
            backgroundImage = ImageIO.read(new File("picturekopia.jpeg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ImageIcon tile_neutral = new ImageIcon("tile.png");
        ImageIcon tile_side_1 = new ImageIcon("tile_side1.png");
        ImageIcon tile_side_2 = new ImageIcon("tile_side2.png");
        ImageIcon melee = new ImageIcon("melee_unit.png");
        ImageIcon axe = new ImageIcon("axe_unit.png");
        ImageIcon range = new ImageIcon("range_unit.png");
        ImageIcon special = new ImageIcon("special_unit.png");
        tiles = new JLabel[size][size];
        units = new JLabel[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                ImageIcon imageIcon1;
                if (j%2==0) {
                    if (i % 4 == 1) imageIcon1 = special;
                    else imageIcon1 = melee;
                }
                else if (i%2==0) imageIcon1 = axe;
                else imageIcon1 = range;

                units[i][j] = new JLabel(imageIcon1,JLabel.CENTER);
                units[i][j].setBounds(100+imageIcon1.getIconWidth()/2*(i+j),500+imageIcon1.getIconHeight()/2*(i-j),imageIcon1.getIconWidth(),imageIcon1.getIconHeight());
                add(units[i][j]);
                ImageIcon imageIcon;
                if (j<5) imageIcon = tile_side_1;
                else if (j>15) imageIcon = tile_side_2;
                else imageIcon = tile_neutral;
                tiles[i][j] = new JLabel(imageIcon,JLabel.CENTER);
                tiles[i][j].setBounds(100+imageIcon.getIconWidth()/2*(i+j),500+imageIcon.getIconHeight()/2*(i-j),imageIcon.getIconWidth(),imageIcon.getIconHeight());
                add(tiles[i][j]);
            }
        }
    }

    private Image backgroundImage;

    /*
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the background image.
        g.drawImage(backgroundImage, 0, 0, this);
    }
    */
}
