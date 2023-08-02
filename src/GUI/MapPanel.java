package GUI;

import Fractions.Units.Unit;
import settings.CurrentGameData;

import javax.swing.*;

public class MapPanel extends JPanel {

    private final JLabel[][] tiles;
    private final JLabel[][] units;
    private final JLabel[][] side;

    ImageIcon tile_neutral = new ImageIcon("tile.png");
    ImageIcon tile_side_1 = new ImageIcon("tile_side1.png");
    ImageIcon tile_side_2 = new ImageIcon("tile_side2.png");

    ImageIcon melee = new ImageIcon("melee_unit.png");

    ImageIcon axe = new ImageIcon("axe_unit.png");

    ImageIcon range = new ImageIcon("range_unit.png");

    ImageIcon special = new ImageIcon("special_unit.png");

    ImageIcon empty = new ImageIcon("empty");
    public MapPanel(int size) {

        setLayout(null);
        tiles = new JLabel[size][size];
        units = new JLabel[size][size];
        side = new JLabel[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                ImageIcon imageIcon1 = tile_neutral;

                units[i][j] = new JLabel(imageIcon1, JLabel.CENTER);
                units[i][j].setBounds(100 + imageIcon1.getIconWidth() / 2 * (i + j), 500 + imageIcon1.getIconHeight() / 2 * (i - j), imageIcon1.getIconWidth(), imageIcon1.getIconHeight());
                add(units[i][j]);
                ImageIcon imageIcon2 = tile_neutral;

                side[i][j] = new JLabel(imageIcon2, JLabel.CENTER);
                side[i][j].setBounds(100 + imageIcon2.getIconWidth() / 2 * (i + j), 500 + imageIcon2.getIconHeight() / 2 * (i - j), imageIcon2.getIconWidth(), imageIcon2.getIconHeight());
                add(side[i][j]);
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                tiles[i][j] = new JLabel(tile_neutral, JLabel.CENTER);
                tiles[i][j].setBounds(100 + tile_neutral.getIconWidth() / 2 * (i + j), 500 + tile_neutral.getIconHeight() / 2 * (i - j), tile_neutral.getIconWidth(), tile_neutral.getIconHeight());
                add(tiles[i][j]);
            }
        }
    }

    public void refresh() {
        for (int i = 0; i < units.length; i++) {
            for (int j = 0; j < units.length; j++) {
                Unit unit = CurrentGameData.battleMap.getUnit(j,i);
                if (unit != null) {
                    //System.out.println(unit.getPositionX());
                    ImageIcon imageIcon1 = unit.imageIcon;

                    units[i][j].setIcon(imageIcon1);

                    ImageIcon imageIcon2;
                    if (unit.getAlliance().isFromNorth()) imageIcon2 = tile_side_1;
                    else imageIcon2 = tile_side_2;

                    side[i][j].setIcon(imageIcon2);
                } else {
                    units[i][j].setIcon(tile_neutral);
                    side[i][j].setIcon(tile_neutral);
                }
            }
        }
        repaint();
        revalidate();
    }
}
