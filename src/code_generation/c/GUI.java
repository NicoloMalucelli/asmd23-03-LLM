package code_generation.c;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUI extends JFrame {
    private final JLabel[][] labels;
    private final Logic logic;

    public GUI(int rows, int cols) {
        setTitle("Rectangular Area Selection");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(rows, cols));
        labels = new JLabel[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                JLabel label = new JLabel("");
                label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                label.setHorizontalAlignment(JLabel.CENTER);
                label.setVerticalAlignment(JLabel.CENTER);
                final int x = i;
                final int y = j;
                label.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        logic.cellClicked(x, y);
                    }
                });
                panel.add(label);
                labels[i][j] = label;
            }
        }

        logic = new LogicImpl(labels);

        add(panel);
        setVisible(true);
    }
}