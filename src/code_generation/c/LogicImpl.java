package code_generation.c;

import javax.swing.*;

class LogicImpl implements Logic {
    private final JLabel[][] labels;
    private int clickCount = 0;
    private int[] firstClick = {-1, -1};

    LogicImpl(JLabel[][] labels) {
        this.labels = labels;
    }

    @Override
    public void cellClicked(int x, int y) {
        if (!allCellsSelected()) {
            if (clickCount == 0) {
                firstClick[0] = x;
                firstClick[1] = y;
                labels[x][y].setText("1");
                clickCount++;
            } else {
                int minX = Math.min(firstClick[0], x);
                int maxX = Math.max(firstClick[0], x);
                int minY = Math.min(firstClick[1], y);
                int maxY = Math.max(firstClick[1], y);
                for (int i = minX; i <= maxX; i++) {
                    for (int j = minY; j <= maxY; j++) {
                        labels[i][j].setText("*");
                    }
                }
                clickCount = 0;
            }
        } else {
            disableAllCells();
        }
    }

    @Override
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

    @Override
    public void disableAllCells() {
        for (JLabel[] row : labels) {
            for (JLabel label : row) {
                label.setEnabled(false);
            }
        }
    }
}