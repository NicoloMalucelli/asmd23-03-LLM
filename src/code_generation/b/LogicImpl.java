package code_generation.b;

class LogicImpl implements Logic {
    private final GUI gui;

    LogicImpl(GUI gui) {
        this.gui = gui;
    }

    @Override
    public void cellClicked(int x, int y) {
        gui.updateCell(x, y);
        if (gui.allCellsSelected()) {
            gui.disableAllCells();
        }
    }
}