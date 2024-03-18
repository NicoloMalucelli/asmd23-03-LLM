package code_generation.c;

interface Logic {
    void cellClicked(int x, int y);

    boolean allCellsSelected();

    void disableAllCells();
}