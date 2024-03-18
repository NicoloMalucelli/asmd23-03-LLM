package code_generation.c;

import javax.swing.*;

public class Test {

    /*
    LLM: ChatGPT 3.5
    Method: Tell the LLM what was the error of the previous implementation (code_generation.b)

    1. the first click should not already mark the cells with *, but put a 1 instead.
    Moreover, when the second click occures, only the cells between the first and the second click should be marked, not all the cell between (0,0) and the clicked one

    2. refactor gui and logic so that ALL the public methods are in the logic and the GUI simply call them

     */

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GUI(5, 5));
    }
}
