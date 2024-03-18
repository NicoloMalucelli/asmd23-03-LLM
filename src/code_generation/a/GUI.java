package code_generation.a;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUI extends JFrame {
    private final int rows = 5;
    private final int cols = 5;
    private final JLabel[][] labels;
    private final Logic logic;

    public GUI() {
        setTitle("Rectangular Area Selection");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(rows, cols));
        labels = new JLabel[rows][cols];
        logic = new LogicImpl(this);

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

        add(panel);
        setVisible(true);
    }

    public boolean allCellsSelected() {
        for (JLabel[] row : labels) {
            for (JLabel label : row) {
                if (!label.getText().equals("*")) {
                    return false;
                }
            }
        }
        return true;
    }

    public void updateRectangle(int x, int y) {
        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= y; j++) {
                labels[i][j].setText("*");
            }
        }
    }

    public void disableAllCells() {
        for (JLabel[] row : labels) {
            for (JLabel label : row) {
                label.setEnabled(false);
            }
        }
    }

}