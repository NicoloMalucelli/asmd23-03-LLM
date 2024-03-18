package code_generation.b;

import code_generation.b.GUI;

import javax.swing.*;

public class Test {

    /*
    LLM: ChatGPT 3.5
    Method: Tell the LLM what was the error of the previous implementation (code_generation.a)

    The obtained solution is not working and moreover it doesn't separate the View aspect from the Logic.

    - The GUI class contains methods that should normally belong to the Logic (e.g., allCellsSelected, updateRectangle, disableAllCells). LogicImpl contains instead just a method that call the public methods of the GUI.
    - The number of rows and cols are not given as parameters of the constructor but are defined inside the GUI class.
    - The logic of the application is wrong. At each click, all the cells between the clicked cell and the top-left corner are marked with *. First click and second click are treated in the same way.
    - When all the cells are marked with * the game doesn't end until an additional click on any cell

     */

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GUI(5, 5));
    }
}
