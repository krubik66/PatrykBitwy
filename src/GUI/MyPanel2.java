package GUI;

import settings.CurrentGameData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyPanel2 extends JPanel implements ActionListener {
    private ChoosingFractionsPanel fractionsPanel;
    private JButton startButton;
    private MapPanel warPanel;

    boolean isFirstOn;

    public MyPanel2(ChoosingFractionsPanel fractionsPanel, MapPanel warPanel) {
        //construct components
        this.fractionsPanel = fractionsPanel;
        this.warPanel = warPanel;
        isFirstOn = true;
        setLayout(null);

        startButton = new JButton("Start");
        startButton.addActionListener(this);
        add(startButton);
        add(this.fractionsPanel);
        startButton.setFont(new Font("Comic Sans MS",Font.PLAIN,32));
        this.fractionsPanel.setBounds(0,0,2000,1000);
        this.warPanel.setBounds(0,0,2000,1000);
        startButton.setBounds(900,0,200,40);
        this.revalidate();
        this.repaint();



        //adjust size and set layout
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (isFirstOn) {
            synchronized (this) {
                remove(fractionsPanel);
                add(warPanel);
                startButton.setBounds(900, 0, 200, 40);
                CurrentGameData.isCurrentlyOngoing = true;
                CurrentGameData.hasStarted = true;
                fractionsPanel.saveComboBoxes();
                notifyAll();
            }
        } else {
            remove(warPanel);
            add(fractionsPanel);
            startButton.setBounds(900,0,200,40);
            CurrentGameData.isCurrentlyOngoing = false;
        }
        fractionsPanel.saveComboBoxes();
        isFirstOn ^= true;
        this.revalidate();
        this.repaint();

    }

}
