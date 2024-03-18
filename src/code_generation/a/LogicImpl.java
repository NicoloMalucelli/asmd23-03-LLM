package code_generation.a;

class LogicImpl implements Logic {
    private final GUI gui;

    LogicImpl(GUI gui) {
        this.gui = gui;
    }

    @Override
    public void cellClicked(int x, int y) {
        if (!gui.allCellsSelected()) {
            gui.updateRectangle(x, y);
        } else {
            gui.disableAllCells();
        }
    }
}